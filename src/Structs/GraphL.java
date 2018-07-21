package Structs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphL {
	class Vertex {
		public int label;
		public int weight;
		public boolean visited;
		public Vertex(int slabel, int sweight) {
			label = slabel;
			weight = sweight;
			visited = false;
		}

	}

	public ArrayList<Vertex> vertexs;
	public LinkedList<Vertex>[] edges;
	public int verticsCount;

	public GraphL(int numvertex) {
		verticsCount = numvertex; // 节点个数
		vertexs = new ArrayList<Vertex>(); // 存节点
		edges = new LinkedList[verticsCount + 1];
		for (int i = 1; i <= verticsCount; i++) { // 初始化边列表
			edges[i] = new LinkedList<Vertex>();
		}
		vertexs.add(null);
		for (int i = 1; i <= numvertex; i++) {
			vertexs.add(new Vertex(i, 0));
			edges[i].add(vertexs.get(i)); // 为每个节点构造一个链接其
		}
	}

	// public GraphL(int[] weights) {
	// verticsCount = weights.length; // 节点个数
	// vertexs = new ArrayList<Vertex>(); // 存节点
	// edges = new LinkedList[verticsCount + 1]; // 边的列表
	// for (int i = 1; i < weights.length; i++) {
	// vertexs.add(new Vertex(i, weights[i]));
	// edges[i].add(vertexs.get(i)); // 为每个节点构造一个链接其
	// }
	// }

	// 无向图
	public void addNoEdges(int source, int destibation) { // 一般来讲 source 就是 label
		int i = vertexs.get(source).label;
		int j = vertexs.get(destibation).label;
		if (i != -1 || j != -1) {
			edges[i].addFirst(vertexs.get(j));
			edges[j].addFirst(vertexs.get(i));
		}
	}

	// 无向有权图
	public void addWeightEdges(int source, int destibation, int weight) { // 一般来讲 source 就是 label
		edges[source].addFirst(new Vertex(destibation, weight));
		edges[destibation].addFirst(new Vertex(source, weight));
	}

	public void DFS(GraphL graph) { // 图的深度遍历 穿进来一个图
		Stack<Vertex> stack = new Stack<Vertex>();
		graph.vertexs.get(1).visited = true; // 图的第一个节点
		stack.push(graph.vertexs.get(1)); // 进栈
		System.out.print(graph.vertexs.get(1).label + " ");
		while (!stack.isEmpty()) {
			int v = getUnVisitedVertex(stack.peek(), graph); // 找到这个节点能够到达的第一个没访问的元素
			if (v == -1) // 如果没找到 自己出来
				stack.pop();
			else {
				graph.vertexs.get(v).visited = true; // 找到了访问这个节点
				System.out.print(graph.vertexs.get(v).label + " ");
				stack.push(graph.vertexs.get(v)); // 这个节点进栈
			}
		}
		// 还原状态
		for (int i = 1; i <= graph.verticsCount; i++) {
			graph.vertexs.get(i).visited = false;
		}
	}

	public void BFS(GraphL graph) { // 图的深度遍历 穿进来一个图
		Queue<Vertex> queue = new LinkedList<Vertex>();
		graph.vertexs.get(1).visited = true; // 图的第一个节点
		queue.add(graph.vertexs.get(1)); // 进队列
		System.out.print(graph.vertexs.get(1).label + " ");
		int v1;
		while (!queue.isEmpty()) {
			Vertex v = queue.remove(); // 这个节点出来
			while ((v1 = getUnVisitedVertex(v, graph)) != -1) { // 把能够到达的没有进去的都放进去
				graph.vertexs.get(v1).visited = true;
				System.out.print(v1 + " ");
				queue.add(graph.vertexs.get(v1));
			}
		}
		for (int i = 1; i <= graph.verticsCount; i++) {
			graph.vertexs.get(i).visited = false;
		}
	}

	public int getUnVisitedVertex(Vertex vertex, GraphL graph) {
		for (Vertex i : graph.edges[vertex.label]) {
			if (i.visited == false)
				return i.label;

		}
		return -1;
	}

	// 查找一个点到所有点之间最短路径 没有权重的就相当于记录是第几层访问就好
	public void UnweightShortPath(GraphL graph, int s) {
		Queue<Vertex> queue = new LinkedList<>();
		Vertex v;
		int w, v1;
		queue.add(graph.vertexs.get(s));
		int[] distinct = new int[graph.verticsCount + 1];
		for (int i = 0; i < distinct.length; i++) {
			distinct[i] = -1;
		}
		distinct[s] = 0; // 自己到自己是0
		while (!queue.isEmpty()) {
			v = queue.remove();
			while ((v1 = getUnVisitedVertex(v, graph)) != -1) {
				graph.vertexs.get(v1).visited = true;
				if (distinct[v1] == -1) { // 已经到达过的肯定是最近的
					distinct[v1] = distinct[v.label] + 1;
					queue.add(graph.vertexs.get(v1));
				}
			}
		}
		for (int i = 1; i <= graph.verticsCount; i++) {
			graph.vertexs.get(i).visited = false;
		}
		for (int i = 1; i < distinct.length; i++) {
			System.out.print(distinct[i] + " ");
		}
	}

	public void MinTree(GraphL graphL) {
		Set<Vertex> set = new HashSet<Vertex>();
		ADT adt = new ADT();
		adt.MakeSet(graphL.verticsCount);
		
		ArrayList<Vertex> aray = new ArrayList<Vertex>();
		ArrayList<Vertex> edges = new ArrayList<Vertex>();
		for (LinkedList<Vertex> i : graphL.edges) {
		
		}
	}

	// 查找一个点到所有点之间最短路径 有权重
	public void WeightShortPath(GraphL graph, int s) {
		Queue<Vertex> queue = new LinkedList<>();
		Vertex v;
		int w;
		Vertex v1;
		LinkedList<Integer>[] path = new LinkedList[graph.verticsCount + 1];
		for (int i = 0; i < path.length; i++) {
			path[i] = new LinkedList<Integer>();
		}
		queue.add(graph.vertexs.get(s));
		int[] distinct = new int[graph.verticsCount + 1];
		for (int i = 0; i < distinct.length; i++) {
			distinct[i] = Integer.MAX_VALUE;
		}
		distinct[s] = 0; // 自己到自己是0
		while (!queue.isEmpty()) {
			v = queue.remove();
			while ((v1 = getVisitVertex(v, graph)) != null) { // 返回的是权重了不是
				// graph.vertexs.get(v1).visited = true;
				if (distinct[v1.label] > distinct[v.label] + v1.weight) {
					distinct[v1.label] = distinct[v.label] + v1.weight;
					path[v1.label].removeAll(path[v1.label]);
					path[v1.label].addAll(path[v.label]);
					path[v1.label].add(v.label);
					queue.add(graph.vertexs.get(v1.label));
				}
			}
		}
		for (int i = 1; i <= graph.verticsCount; i++) {
			graph.vertexs.get(i).visited = false;
		}
		// System.out.println();
		// for(int i=1;i<distinct.length;i++) {
		// System.out.print(distinct[i]+" ");
		// }
		for (int i = 1; i < path.length; i++) {
			System.out.print("从" + s + "到" + i + "的最短路径为:" + distinct[i] + "   路线为: ");
			for (int num : path[i]) {
				System.out.print(num + "->");
			}
			System.out.println(i);
		}
	}

	private Vertex getVisitVertex(Vertex v, GraphL graph) {
		for (Vertex i : graph.edges[v.label]) {
			if (i.visited == false) {
				i.visited = true;
				return i;
			}
		}
		return null;
	}

}
