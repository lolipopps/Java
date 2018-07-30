package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MatrixGraph {
	class Vertex {
		public int label;
		public boolean visited;
		public Vertex(int lab) {
			label = lab;
			visited = false;
		}
	}

	private int adjMatrix[][];
	private int vertexCount;
	private Vertex vertexList[];
	private Stack<Integer> theStack;
	private Queue<Integer> theQueue;

	public MatrixGraph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjMatrix = new int[vertexCount][vertexCount];
		vertexList = new Vertex[vertexCount];
		theQueue = new LinkedList<Integer>();
		theStack = new Stack<Integer>();
		adjMatrix[1][2] = adjMatrix[2][1] = 3;
		adjMatrix[2][3] = adjMatrix[3][2] = 3;
		adjMatrix[1][3] = adjMatrix[3][1] = 3;
		adjMatrix[3][4] = adjMatrix[4][3] = 3;
		adjMatrix[4][5] = adjMatrix[5][4] = 3;
		adjMatrix[3][5] = adjMatrix[5][3] = 3;
		adjMatrix[5][6] = adjMatrix[6][5] = 3;

	}

	public void addEdge(int i, int j, int w) {
		if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
			adjMatrix[i][j] = w;
			adjMatrix[j][i] = w;
		}
	}

	public void removeEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
			adjMatrix[i][j] = -1;
			adjMatrix[j][i] = -1;
		}
	}

	public int isEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
			return adjMatrix[i][j];

		}
		return -1;
	}

	private void displayVertex(int i) {
		System.out.println(vertexList[i].label);

	}

	public void dfs() {
		vertexList[0].visited = true;
		displayVertex(0);
		theStack.push(0);
		while (!theStack.isEmpty()) {
			int v = getUnvisitedVertex((int) theStack.peek());
			if (v == -1) {
				theStack.pop();
			} else {
				vertexList[v].visited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		for (int j = 0; j < vertexCount; j++) {
			vertexList[j].visited = false;
		}

	}

	
	public void Rdfs() {
		vertexList[0].visited = true;
		displayVertex(0);
		theStack.push(0);
		while (!theStack.isEmpty()) {
			int v = getUnvisitedVertex((int) theStack.peek());
			if (v == -1) {
				theStack.pop();
			} else {
				vertexList[v].visited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		for (int j = 0; j < vertexCount; j++) {
			vertexList[j].visited = false;
		}

	}
	
	public void bfs() {
		vertexList[0].visited = true;
		displayVertex(0);
		theQueue.add(0);
		int v2;
		while (!theQueue.isEmpty()) {
			int v1 = theQueue.remove();
			while ((v2 = getUnvisitedVertex(v1)) != -1) {
				vertexList[v2].visited = true;
				displayVertex(v2);
				theQueue.add(v2);
			}
		}
		for (int j = 0; j < vertexCount; j++) {
			vertexList[j].visited = false;
		}
	}

	public int getUnvisitedVertex(int v) {
		for (int j = 0; j < vertexCount; j++) {
			if (adjMatrix[v][j] == 1 && vertexList[j].visited == false)
				return j;
		}
		return -1;
	}
	public Set getRoute(int begin,int end){
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		stack.add(begin);
		set.add(begin);
		while(!stack.isEmpty()) {
			int v = stack.peek();
			for(int i=1;i<=vertexCount;i++) {
				if(adjMatrix[v][i]>0 && !set.contains(i)) {
					if(i == end) {
						System.out.println("找到一条路");
						  for (int x : stack) { 
		                        System.out.println(x); 
		                }
					}
					stack.add(i);
					break;
				}
				if(i == vertexCount) {
					v = stack.pop();
				}
			}
		}
		return null;
		
	}
	public void getMinCost() {
		
	}
}
