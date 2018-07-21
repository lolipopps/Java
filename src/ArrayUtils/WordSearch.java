package ArrayUtils;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'D' } };
		System.out.println(exist(board,"SEE"));

	}

	
	public static boolean exist(char[][] board, String word) {
	    for(int i = 0; i < board.length; i++) {
	        for(int j = 0; j < board[0].length; j++) {
	            if(exist(board, word, 0, i, j)) return true;
	        }
	    }
	    return false;
	}

	public static boolean exist(char[][] board, String word, int currentIndex, int row, int col) {
	    if(currentIndex == word.length()) return true;
	    
	    if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(currentIndex)) return false;
	    
	    char tmp = board[row][col];
	    board[row][col] = '*';
	    
	    boolean result = exist(board, word, currentIndex + 1, row + 1, col)
	        || exist(board, word, currentIndex + 1, row - 1, col)
	        || exist(board, word, currentIndex + 1, row, col + 1)
	        || exist(board, word, currentIndex + 1, row, col - 1);
	    
	    board[row][col] = tmp;
	    
	    return result;
	}
}
