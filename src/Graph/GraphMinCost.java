package Graph;

public class GraphMinCost {
	public static void main(String[] args) {
		int nodecont = 6;
		int[][][] graph = new int[nodecont][nodecont][2];  // 定义了一个邻接矩阵
		//初始化矩阵
		for(int i=1;i<= nodecont;i++) {
			
		}
		graph[1][2][0] = graph[2][1][0] = 2;
		graph[1][2][1] = graph[2][1][1] = 3;
		
		graph[2][3][0] = graph[2][3][0] = 2;
		graph[2][3][0] = graph[2][3][0] = 2;
		
		graph[1][3][0] = graph[3][1][0] = 1;
		graph[3][1][0] = graph[1][3][0] = 30;
		
		
		graph[3][4][0] = graph[4][3][0] = 1;
		graph[3][4][0] = graph[4][3][0] = 20;
		
		graph[4][5][0] = graph[5][4][0] = 1;
		graph[4][5][0] = graph[5][4][0] = 30;
		
		graph[3][5][0] = graph[5][3][0] = 2;
		graph[3][5][0] = graph[5][3][0] = 6;
		
		graph[6][5][0] = graph[5][6][0] = 2;
		graph[6][5][0] = graph[5][6][0] = 1;
	
	
	}		
	
		

}
