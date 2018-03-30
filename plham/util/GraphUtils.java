package plham.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphUtils implements Serializable {
	private static final long serialVersionUID = 5229104023562464389L;

	/*
	public static def toAdjacencySet[T](nodes:Set[T], pairs:Set[Pair[T,T]]):Map[T,Set[T]] {
		val graph = new HashMap[T,Set[T]]();
		for (i in nodes) {
			graph(i) = new HashSet[T]();
		}
		for (key in pairs) {
			val i = key.first; // From
			val j = key.second; // To
			graph(i).add(j);
		}
		return graph;
	}
	*/
	public static <T> Map<T, Set<T>> toAdjacencySet(Set<T> nodes,
			Set<List<T>> pairs) {
		Map<T, Set<T>> graph = new HashMap<T, Set<T>>();
		for (T i : nodes) {
			graph.put(i, new HashSet<T>());
		}
		for (List<T> key : pairs) {
			T i = key.get(0);
			T j = key.get(1);
			graph.get(i).add(j);
		}
		return graph;
	}

	/*
	public static def getConnectedComponents[T](nodes:Set[T], pairs:Set[Pair[T,T]]):List[Set[T]] {
		val graph = toAdjacencySet(nodes, pairs);
		return getConnectedComponents(graph);
	}
	*/
	public static <T> List<Set<T>> getConnectedComponents(Set<T> nodes,
			Set<List<T>> pairs) {
		Map<T, Set<T>> graph = toAdjacencySet(nodes, pairs);
		return getConnectedComponents(graph);
	}

	/*
	public static def getConnectedComponents[T](graph:Map[T,Set[T]]):List[Set[T]] {
		val out = new ArrayList[Set[T]]();
		val checked = new HashSet[T]();
		for (root in graph.keySet()) {
			if (checked.contains(root)) {
				continue;
			}

			Console.OUT.println("#GRAPH " + root + " checking");
			val visited = new HashSet[T]();
			val stack = new Stack[T]();
			stack.push(root);
			while (stack.size() > 0) {
				val key = stack.pop();
				if (visited.contains(key)) {
					continue;
				}
				visited.add(key);
				Console.OUT.println("#GRAPH " + key + " checking(sub)");
				for (child in graph(key)) {
					assert graph(child).contains(key) : "Undirected graph only supported";
					stack.push(child);
					Console.OUT.println("#GRAPH " + key + " --> " + child + " connected");
				}
			}
			out.add(visited);
			checked.addAll(visited);
		}
		Console.OUT.println("#GRAPH finished");
		return out;
	}
	*/
	public static <T> List<Set<T>> getConnectedComponents(Map<T, Set<T>> graph) {
		List<Set<T>> out = new ArrayList<Set<T>>();
		Set<T> checked = new HashSet<T>();
		for (T root : graph.keySet()) {
			if (checked.contains(root)) {
				continue;
			}

			Set<T> visited = new HashSet<T>();
			Stack<T> stack = new Stack<T>();
			stack.push(root);
			while (stack.size() > 0) {
				T key = stack.pop();
				if (visited.contains(key)) {
					continue;
				}
				visited.add(key);
				for (T child : graph.get(key)) {
					assert graph.get(child).contains(key) : "Undirected graph only supported";
					stack.push(child);
				}
			}
			out.add(visited);
			checked.addAll(visited);
		}
		return out;
	}

	/*
	public static def dump[T](graph:Map[T,Set[T]]) {
		for (i in graph.keySet()) {
			Console.OUT.print("# ");
			Console.OUT.print(i + ": ");
			for (j in graph(i)) {
				Console.OUT.print(j + " ");
			}
			Console.OUT.println();
		}
	}

	public static def dump[T](list:List[Set[T]]) {
		for (cc in list) {
			Console.OUT.print("# ");
			for (j in cc) {
				Console.OUT.print(j + " ");
			}
			Console.OUT.println();
		}
	}

	public static def main(args:Rail[String]) {
		var T:Long = 100;
		var N:Long = 10;
		if (args.size > 0) {
			T = Long.parse(args(0));
		}
		if (args.size > 1) {
			N = Long.parse(args(1));
		}
		val random = new Random();

		val graph = new HashMap[Long,Set[Long]]();
		for (i in 0..(N - 1)) {
			graph(i) = new HashSet[Long]();
		}
		for (t in 1..T) {
			val i = random.nextLong(N);
			val j = random.nextLong(N);
			graph(i).add(j);
			graph(j).add(i);
		}
		dump(graph);

		val C = getConnectedComponents(graph);
		dump(C);

		Console.OUT.println("#### #### #### ####");

		val pairs = new HashSet[Pair[Long,Long]]();
		for (i in 0..(N - 1)) {
			for (j in graph(i)) {
				pairs.add(Pair[Long,Long](i, j));
			}
		}

		val pG = toAdjacencySet(graph.keySet(), pairs);
		dump(pG);

		val pC = getConnectedComponents(pG);
		dump(pC);
	}
	*/
}
