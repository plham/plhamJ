package plham.core.util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphUtils implements Serializable {
	public static class KeyPair<S extends Comparable<S>> extends Pair<S> {
		/**
		 *
		 */
		private static final long serialVersionUID = 8651905559142003252L;

		public KeyPair(S a, S b) {
			super(b.compareTo(a) < 0 ? a : b, b.compareTo(a) < 0 ? b : a);
		}

		@Override
		public int hashCode() {
			return getFirst().hashCode() ^ getSecond().hashCode();
		}
	}

	public static class Pair<S> extends AbstractMap.SimpleImmutableEntry<S, S> {
		/**
		 *
		 */
		private static final long serialVersionUID = -8335299726209210920L;

		public Pair(S a, S b) {
			super(a, b);
		}

		public S getFirst() {
			return getKey();
		}

		public S getSecond() {
			return getValue();
		}
	}

	private static final long serialVersionUID = 5229104023562464389L;

	public static <T> List<Set<T>> getConnectedComponents(Map<T, Set<T>> graph) {
		List<Set<T>> out = new ArrayList<>();
		Set<T> checked = new HashSet<>();
		for (T root : graph.keySet()) {
			if (checked.contains(root)) {
				continue;
			}

			System.out.println("#GRAPH " + root + " checking");
			Set<T> visited = new HashSet<>();
			Stack<T> stack = new Stack<>();
			stack.push(root);
			while (stack.size() > 0) {
				T key = stack.pop();
				if (visited.contains(key)) {
					continue;
				}
				visited.add(key);
				System.out.println("#GRAPH " + key + " checking(sub)");
				for (T child : graph.get(key)) {
					assert graph.get(child).contains(key) : "Undirected graph only supported";
					stack.push(child);
					System.out.println("#GRAPH " + key + " --> " + child + " connected");
				}
			}
			out.add(visited);
			checked.addAll(visited);
		}
		System.out.println("#GRAPH finished");
		return out;
	}

	public static <T> List<Set<T>> getConnectedComponents(Set<T> nodes, Set<? extends Pair<T>> pairs) {
		Map<T, Set<T>> graph = toAdjacencySet(nodes, pairs);
		return getConnectedComponents(graph);
	}

	public static <T> Map<T, Set<T>> toAdjacencySet(Set<T> nodes, Set<? extends Pair<T>> pairs) {
		Map<T, Set<T>> graph = new LinkedHashMap<>();
		for (T i : nodes) {
			graph.put(i, new HashSet<T>());
		}
		for (Pair<T> key : pairs) {
			T i = key.getFirst();
			T j = key.getSecond();
			graph.get(i).add(j);
		}
		return graph;
	}
}
