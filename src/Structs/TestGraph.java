package Structs;

public class TestGraph {

	public static void main(String[] args) {
		GraphL graph = new GraphL(6);
		graph.addNoEdges(1, 2);
		graph.addNoEdges(1, 6);
		graph.addNoEdges(2, 4);
		graph.addNoEdges(2, 3);
		graph.addNoEdges(4, 5);
		graph.addNoEdges(3, 5);
		graph.addNoEdges(3, 6);
		graph.DFS(graph);
		System.out.println();
		graph.BFS(graph);
		System.out.println();
		graph.UnweightShortPath(graph, 3);
		System.out.println();
		graph = new GraphL(6);
		graph.addWeightEdges(1, 2, 3);
		graph.addWeightEdges(1, 6, 2);
		graph.addWeightEdges(2, 4, 4);
		graph.addWeightEdges(2, 6, 1);
		graph.addWeightEdges(2, 3, 3);
		graph.addWeightEdges(4, 5, 8);
		graph.addWeightEdges(3, 5, 2);
		graph.addWeightEdges(3, 6, 1);
		graph.WeightShortPath(graph, 3);
	}

}
