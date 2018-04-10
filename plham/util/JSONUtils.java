package plham.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import cassia.util.JSON;

public class JSONUtils implements Serializable {
	private static final long serialVersionUID = 3679596971220644798L;

	/*
	private static class Graph {
		private val NodeID:HashMap[String, Long];
		private val NodeName:Rail[String];
		private val V:Long; // the number of vertices
		private val g:Rail[ArrayList[Long]];  // the graph represented by adjacency list
		private val rg:Rail[ArrayList[Long]]; // the reverse graph of g
	*/
	private static class Graph {
		private Map<String, Long> NodeID;
		private List<String> NodeName;
		private long V;
		private List<List<Long>> g;
		private List<List<Long>> rg;

		/*
		public def this(originalGraph:Map[String, Set[String]]) {
			V = originalGraph.size();
			g = new Rail[ArrayList[Long]](V);
			rg = new Rail[ArrayList[Long]](V);
			for (v in 0 .. (V - 1)) {
				g(v) = new ArrayList[Long]();
				rg(v) = new ArrayList[Long]();
			}
			NodeID = new HashMap[String, Long]();
			NodeName = new Rail[String](V);
			var curID:Long = 0;
			for (key in originalGraph.keySet()) {
				if (NodeID.containsKey(key)) continue;
				NodeName(curID) = key;
				NodeID(key) = curID++;
			}
			assert curID == this.V;
			for (entry in originalGraph.entries()) {
				val dst = NodeID(entry.getKey());
				for (v in entry.getValue()) {
					val src = NodeID(v);
					Console.OUT.println("# src: " + src + " dst: " + dst + " V: " + V);
					addEdge(src, dst);
				}
			}
		}
		 */
		public Graph(Map<String, Set<String>> originalGraph) {
			V = originalGraph.size();
			g = new ArrayList<List<Long>>((int) (V));
			rg = new ArrayList<List<Long>>((int) (V));
			for (long v = 0; v < V - 1; v++) {
				g.set((int) v, new ArrayList<Long>());
				rg.set((int) v, new ArrayList<Long>());
			}
			NodeID = new HashMap<String, Long>();
			NodeName = new ArrayList<String>((int) V);
			long curID = 0;
			for (Map.Entry<String, Set<String>> e : originalGraph.entrySet()) {
				String key = e.getKey();
				if (NodeID.containsKey(key)) {
					continue;
				}
				NodeName.set((int) curID, key);
				NodeID.put(key, curID++);
			}
			assert curID == this.V;
			for (Map.Entry<String, Set<String>> e : originalGraph.entrySet()) {
				String key = e.getKey();
				long dst = NodeID.get(key);
				Set<String> values = e.getValue();
				for (String v : values) {
					long src = NodeID.get(v);
					System.out.println("# src: " + src + " dst: " + dst
							+ " V: " + V);
					addEdge(src, dst);
				}
			}
		}

		/*
		private def addEdge(val src:Long, val dst:Long) {
			g(src).add(dst);
			rg(dst).add(src);
		}
		 */
		private void addEdge(long src, long dst) {
			g.get((int) src).add(dst);
			rg.get((int) dst).add(src);
		}

		/*
		public def sort():Rail[String] {
			val order = calcTopologicalOrder();
			val ans = new Rail[String](V);
			for (i in 0 .. (V - 1)) {
				ans( order(i) ) = NodeName(i);
			}
			return ans;
		}
		 */
		public List<String> sort() {
			List<Long> order = calcTopologicalOrder();
			List<String> ans = new ArrayList<String>((int) V);
			for (long i = 0; i < V - 1; i++) {
				ans.set(order.get((int) i).intValue(), NodeName.get((int) i));
			}
			return ans;
		}

		/*
		private def calcTopologicalOrder():Rail[Long] {
			val used = new Rail[Boolean](V, false);
			val vs = new ArrayList[Long]();
			for (v in 0 .. (V - 1)) {
				if (used(v)) continue;
				forward(v, vs, used);
			}
			for (i in used.range()) { used(i) = false; }
			var k:Long = 0;
			val order = new Rail[Long](V);
			for (i in order.range()) { order(i) = -1; }
			vs.reverse();
			for (v in vs) {
				if (used(v)) continue;
				back(v, k++, order, vs, used);
			}
			return order;
		}
		 */
		private List<Long> calcTopologicalOrder() {
			List<Boolean> used = new ArrayList<Boolean>((int) V);
			for (long i = 0; i < V - 1; i++) {
				used.set((int) i, false);
			}
			List<Long> vs = new ArrayList<Long>();
			for (long v = 0; v < V - 1; v++) {
				if (used.get((int) v)) {
					continue;
				}
				forward(v, vs, used);
			}
			for (long i = 0; i < used.size(); i++) {
				used.set((int) i, false);
			}
			long k = 0;
			List<Long> order = new ArrayList<Long>((int) V);
			for (long i = 0; i < order.size(); i++) {
				order.set((int) i, -1L);
			}
			Collections.reverse(vs);
			for (long v : vs) {
				if (used.get((int) v)) {
					continue;
				}
				back(v, k++, order, vs, used);
			}
			return order;
		}

		/*
		private def forward(v:Long, vs:ArrayList[Long], used:Rail[Boolean]):void {
			used(v) = true;
			for (u in g(v)) {
				if (used(u)) continue;
				forward(u, vs, used);
			}
			vs.add(v);
		}
		 */
		private void forward(long v, List<Long> vs, List<Boolean> used) {
			used.set((int) v, true);
			for (long u : g.get((int) v)) {
				if (used.get((int) u)) {
					continue;
				}
				forward(u, vs, used);
			}
			vs.add(v);
		}

		/*
		private def back(v:Long, k:Long, order:Rail[Long], vs:ArrayList[Long], used:Rail[Boolean]):void {
			used(v) = true;
			order(v) = k;
			for (u in rg(v)) {
				if (used(u)) continue;
				back(u, k, order, vs, used);
			}
		}
		 */
		private void back(long v, long k, List<Long> order, List<Long> vs,
				List<Boolean> used) {
			used.set((int) v, true);
			order.set((int) v, k);
			for (long u : rg.get((int) v)) {
				if (used.get((int) u)) {
					continue;
				}
				back(u, k, order, vs, used);
			}
		}
	}

	/*
	public static def getDependencyGraph(root:JSON.Value, list:JSON.Value, keywords:List[String]):Map[String, Set[String]] {
		val graph = new HashMap[String, Set[String]]();
		val stack = new Stack[String]();
		for (i in 0 .. (list.size() - 1)) {
			val name = list(i).toString();
			stack.push(name);
		}
		while (stack.size() > 0) {
			val name = stack.pop();
			Console.OUT.println("#GRAPH " + name + " checking");
			if (! graph.containsKey(name)) {
				graph(name) = new HashSet[String]();
			}
			for (keyword in keywords) {
				if (root(name).has(keyword)) {
					val children = root(name)(keyword);
					for (i in 0 .. (children.size() - 1)) {
						val child = children(i).toString();
						stack.push(child);
						graph(name).add(child);
						Console.OUT.println("#GRAPH " + name + " --> " + child + " created");
					}
				}
			}
		}
		return graph;
	}
	*/
	public static Map<String, Set<String>> getDependencyGraph(JSON.Value root,
			JSON.Value list, List<String> keywords) {
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		Stack<String> stack = new Stack<String>();
		for (long i = 0; i < list.size() - 1; i++) {
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
					for (long i = 0; i < children.size() - 1; i++) {
						String child = children.get(i).toString();
						stack.push(child);
						graph.get(name).add(child);
						System.out.println("#GRAPH " + name + " --> " + child
								+ " created");
					}
				}
			}
		}
		return graph;
	}

	/*
	public static def getDependencySortedList(root:JSON.Value, list:JSON.Value, keywords:List[String]):List[String] {
		val graph = new Graph(getDependencyGraph(root, list, keywords));
		val rail = graph.sort();
		val retval = new ArrayList[String]();
		retval.addAll(rail);
		Console.OUT.println("#GRAPH-SORTED " + retval);
		return retval;
	}
	*/
	public static List<String> getDependencySortedList(JSON.Value root,
			JSON.Value list, List<String> keywords) {
		Graph graph = new Graph(getDependencyGraph(root, list, keywords));
		List<String> rail = graph.sort();
		List<String> retval = new ArrayList<String>();
		retval.addAll(rail);
		System.out.println("#GRAPH-SORTED " + retval);
		return retval;
	}

	/*
	public static def getDependencyGraph(root:JSON.Value, list:JSON.Value, keyword:String):Map[String,Set[String]] {
		val graph = new HashMap[String,Set[String]]();
		val stack = new Stack[String]();
		for (i in 0..(list.size() - 1)) {
			val name = list(i).toString();
			stack.push(name);
		}
		var t:Long = 0;
		while (stack.size() > 0) {
			val name = stack.pop();
			Console.OUT.println("#GRAPH " + name + " checking");
			if (!graph.containsKey(name)) {
				graph(name) = new HashSet[String]();
			}
			if (root(name).has(keyword)) {
				val children = root(name)(keyword);
				for (j in 0..(children.size() - 1)) {
					val child = children(j).toString();
					stack.push(child);
					graph(name).add(child);
					Console.OUT.println("#GRAPH " + name + " --> " + child + " created");
				}
			}
			t++;
		}
		return graph;
	}
	*/
	@SuppressWarnings("unused")
	public static Map<String, Set<String>> getDependencyGraph(JSON.Value root,
			JSON.Value list, String keyword) {
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		Stack<String> stack = new Stack<String>();
		for (long i = 0; i < list.size(); i++) {
			String name = list.get((int) i).toString();
			stack.push(name);
		}
		long t = 0;
		while (stack.size() > 0) {
			String name = stack.pop();
			System.out.println("#GRAPH " + name + " checking");
			if (!graph.containsKey(name)) {
				graph.put(name, new HashSet<String>());
			}
			if (root.get(name).has(keyword)) {
				JSON.Value children = root.get(name).get(keyword);
				for (long i = 0; i < children.size() - 1; i++) {
					String child = children.get((int) i).toString();
					stack.push(child);
					graph.get(name).add(child);
					System.out.println("#GRAPH " + name + " --> " + child
							+ " created");
				}
			}
			t++;
		}
		return graph;
	}

	/*
	public static def getDependencySortedList(root:JSON.Value, list:JSON.Value, keyword:String):List[String] {
		val graph = getDependencyGraph(root, list, keyword);
		val nodes = new ArrayList[String]();
		nodes.addAll(graph.keySet()); // X10 doesn't allow in-loop state changes.

		// TODO: Efficient algorithm.
		val sorted = new ArrayList[String]();
		while (graph.size() > 0) {
			val numNodes = graph.size();
			for (name in nodes) {
				if (graph(name).size() == 0) {
					sorted.add(name);
					for (parent in graph.keySet()) {
						if (graph(parent).remove(name)) {
							Console.OUT.println("#GRAPH " + parent + " --> " + name + " removed");
						}
					}
					graph.remove(name);
					nodes.remove(name);
					Console.OUT.println("#GRAPH " + name + " removed");
				}
			}
			if (numNodes == graph.size()) {
				throw new Exception("Circular dependency of '" + keyword + "' detected");
			}
		}
		Console.OUT.println("#GRAPH-SORTED " + sorted);
		return sorted;
	}
	 */
	public static List<String> getDependencySortedList(JSON.Value root,
			JSON.Value list, String keyword) {
		Map<String, Set<String>> graph = getDependencyGraph(root, list, keyword);
		List<String> nodes = new ArrayList<String>();
		nodes.addAll(graph.keySet()); // X10 doesn't allow in-loop state
										// changes.

		// TODO: Efficient algorithm.
		List<String> sorted = new ArrayList<String>();
		while (graph.size() > 0) {
			int numNodes = graph.size();
			for (int i = 0; i < nodes.size(); i++) {
				String name = nodes.get(i);
				if (graph.get(name).size() == 0) {
					sorted.add(name);
					for (Map.Entry<String, Set<String>> e : graph.entrySet()) {
						String parent = e.getKey();
						if (graph.get(parent).remove(name)) {
							System.out.println("#GRAPH " + parent + " --> "
									+ name + " removed");
						}
					}
					graph.remove(name);
					nodes.remove(name);
					System.out.println("#GRAPH " + name + " removed");
				}
			}
			if (numNodes == graph.size()) {
				throw new RuntimeException("Circular dependency of '" + keyword
						+ "' detected");
			}
		}
		System.out.println("#GRAPH-SORTED " + sorted);
		return sorted;
	}
}
