package plham.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import cassia.util.JSON;

public class JSONUtils implements Serializable {
	private static class Graph {
		private List<List<Integer>> g;
		private Map<String, Integer> NodeID;
		private List<String> NodeName;
		private List<List<Integer>> rg;
		private int V;

		public Graph(Map<String, Set<String>> originalGraph) {
			V = originalGraph.size();
			g = new ArrayList<>(V);
			rg = new ArrayList<>(V);
			for (int i = 0; i < V; i++) {
				g.add(new ArrayList<Integer>());
				rg.add(new ArrayList<Integer>());
			}
			NodeID = new LinkedHashMap<>();
			NodeName = new ArrayList<>(V);
			NodeName.addAll(Collections.nCopies(V, (String) null));
			int curID = 0;
			for (Map.Entry<String, Set<String>> e : originalGraph.entrySet()) {
				String key = e.getKey();
				if (NodeID.containsKey(key)) {
					continue;
				}
				NodeName.set(curID, key);
				NodeID.put(key, curID++);
			}
			assert curID == V;
			for (Map.Entry<String, Set<String>> e : originalGraph.entrySet()) {
				String key = e.getKey();
				int dst = NodeID.get(key);
				Set<String> values = e.getValue();
				for (String v : values) {
					int src = NodeID.get(v);
					System.out.println("# src: " + src + " dst: " + dst + " V: " + V);
					addEdge(src, dst);
				}
			}
		}

		private void addEdge(int src, int dst) {
			g.get(src).add(dst);
			rg.get(dst).add(src);
		}

		private void back(int v, int k, List<Integer> order, List<Integer> vs, List<Boolean> used) {
			used.set(v, true);
			order.set(v, k);
			for (int u : rg.get(v)) {
				if (used.get(u)) {
					continue;
				}
				back(u, k, order, vs, used);
			}
		}

		private List<Integer> calcTopologicalOrder() {
			List<Boolean> used = new ArrayList<>(V);
			used.addAll(Collections.nCopies(V, (Boolean) null));
			for (int i = 0; i < V; i++) {
				used.set(i, false);
			}
			List<Integer> vs = new ArrayList<>();
			for (int v = 0; v < V; v++) {
				if (used.get(v)) {
					continue;
				}
				forward(v, vs, used);
			}
			for (int i = 0; i < used.size(); i++) {
				used.set(i, false);
			}
			int k = 0;
			ArrayList<Integer> order = new ArrayList<>(V);
			order.addAll(Collections.nCopies(V, -1));
			Collections.reverse(vs);
			for (int v : vs) {
				if (used.get(v)) {
					continue;
				}
				back(v, k++, order, vs, used);
			}
			return order;
		}

		private void forward(int v, List<Integer> vs, List<Boolean> used) {
			used.set(v, true);
			for (int u : g.get(v)) {
				if (used.get(u)) {
					continue;
				}
				forward(u, vs, used);
			}
			vs.add(v);
		}

		public List<String> sort() {
			List<Integer> order = calcTopologicalOrder();
			List<String> ans = new ArrayList<>(V);
			ans.addAll(Collections.nCopies(V, (String) null));
			for (int i = 0; i < V; i++) {
				ans.set(order.get(i), NodeName.get(i));
			}
			return ans;
		}
	}

	private static final long serialVersionUID = 3679596971220644798L;

	public static Map<String, Set<String>> getDependencyGraph(JSON.Value root, JSON.Value list, List<String> keywords) {
		// FIXME: the sort oder depends of the order of HashMap (implementation depend)
		Map<String, Set<String>> graph = new LinkedHashMap<>();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).toString();
			stack.push(name);
		}
		while (stack.size() > 0) {
			String name = stack.pop();
			System.out.println("#GRAPH " + name + " checking");
			if (!graph.containsKey(name)) {
				graph.put(name, new HashSet<String>());
			}
			for (String keyword : keywords) {
				if (root.get(name).has(keyword)) {
					JSON.Value children = root.get(name).get(keyword);
					for (int i = 0; i < children.size() - 1; i++) {
						String child = children.get(i).toString();
						stack.push(child);
						graph.get(name).add(child);
						System.out.println("#GRAPH " + name + " --> " + child + " created");
					}
				}
			}
		}
		return graph;
	}

	public static Map<String, Set<String>> getDependencyGraph(JSON.Value root, JSON.Value list, String keyword) {
		Map<String, Set<String>> graph = new LinkedHashMap<>();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).toString();
			stack.push(name);
		}
		while (stack.size() > 0) {
			String name = stack.pop();
			System.out.println("#GRAPH " + name + " checking");
			if (!graph.containsKey(name)) {
				graph.put(name, new HashSet<String>());
			}
			if (root.get(name).has(keyword)) {
				JSON.Value children = root.get(name).get(keyword);
				for (int i = 0; i < children.size() - 1; i++) {
					String child = children.get(i).toString();
					stack.push(child);
					graph.get(name).add(child);
					System.out.println("#GRAPH " + name + " --> " + child + " created");
				}
			}
		}
		return graph;
	}

	public static List<String> getDependencySortedList(JSON.Value root, JSON.Value list, List<String> keywords) {
		Graph graph = new Graph(getDependencyGraph(root, list, keywords));
		List<String> rail = graph.sort();
		List<String> retval = new ArrayList<>();
		retval.addAll(rail);
		System.out.println("#GRAPH-SORTED " + retval);
		return retval;
	}

	public static List<String> getDependencySortedList(JSON.Value root, JSON.Value list, String keyword) {
		Map<String, Set<String>> graph = getDependencyGraph(root, list, keyword);
		List<String> nodes = new ArrayList<>();
		nodes.addAll(graph.keySet()); // X10 doesn't allow in-loop state
										// changes.

		// TODO: Efficient algorithm.
		List<String> sorted = new ArrayList<>();
		while (graph.size() > 0) {
			int numNodes = graph.size();
			for (int i = 0; i < nodes.size(); i++) {
				String name = nodes.get(i);
				if (graph.get(name).size() == 0) {
					sorted.add(name);
					for (Map.Entry<String, Set<String>> e : graph.entrySet()) {
						String parent = e.getKey();
						if (graph.get(parent).remove(name)) {
							System.out.println("#GRAPH " + parent + " --> " + name + " removed");
						}
					}
					graph.remove(name);
					nodes.remove(name);
					System.out.println("#GRAPH " + name + " removed");
				}
			}
			if (numNodes == graph.size()) {
				throw new RuntimeException("Circular dependency of '" + keyword + "' detected");
			}
		}
		System.out.println("#GRAPH-SORTED " + sorted);
		return sorted;
	}
}
