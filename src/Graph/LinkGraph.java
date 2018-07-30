package Graph;

import java.util.ArrayList;

import Structs.ListNode;

public class LinkGraph {
	private int[] visited;
	private int nodeCount;
	private EdgeNode[] graph;
	class EdgeNode{  // 定义节点
		int adjvex;  // 
		int weight;
		int way;
		EdgeNode nextEdge;
		public EdgeNode(int adjvex,int weight,int way) {
			this.adjvex = adjvex;
			this.weight = weight;
			this.way = way;
			this.nextEdge = null;
		}
		
	}
	public LinkGraph(int nodeCount) {
		this.nodeCount = nodeCount;
		this.graph = new EdgeNode[nodeCount+1];
		graph[1].nextEdge = new EdgeNode(2,3,1);
		graph[1].nextEdge.nextEdge = new EdgeNode(3, 30, 0);
	}
}
