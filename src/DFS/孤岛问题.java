package DFS;


public class 孤岛问题 {
	public static void main(String[] args) {
		int[][] num = new int[][] {
			{1,1,1,1,0},
			{1,1,0,1,0},
			{1,1,0,0,0},
			{0,0,1,0,1}
		}; 
		System.out.println(numIslands(num));
		
	}
	public static int numIslands(int[][] grid) {   // 图的遍历
        if (grid.length==0 || grid[0].length==0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        boolean[][] visited = new boolean[m][n] ;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    numIslandsDFS(grid, visited, i, j);
                    ++res;
                }
            }
        }
        return res;
    }
    static void numIslandsDFS(int[][] grid, boolean[][] visited, int x, int y) { // 图的递归遍历
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        if (grid[x][y] != 1 || visited[x][y]) return;
        visited[x][y] = true; // 通过这个来判断是否被访问
        numIslandsDFS(grid, visited, x - 1, y);
        numIslandsDFS(grid, visited, x + 1, y);
        numIslandsDFS(grid, visited, x, y - 1);
        numIslandsDFS(grid, visited, x, y + 1);
    }
}
