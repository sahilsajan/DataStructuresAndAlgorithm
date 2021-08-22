package JavaCode;

public class RatInAMazeSolution {
	
	public static boolean ratInAMaze(int maze[][]) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze(maze, 0, 0, path);
	}

	public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		int n = maze.length;
		//check if i, j cell is valid or not (base case)
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		
		//include the cell in current path so we don't go back to where we came from
		path[i][j] = 1;
		
		//destination cell
		if(i == n-1 && j == n-1) {
			path[i][j] = 0;
			return true;
		}
		
		//use recursion and explore further in all directions
		boolean pathPossible = false;
		//top
		if(solveMaze(maze, i-1, j, path)) {
			pathPossible = true;
		}
		//right
		else if(solveMaze(maze, i, j+1, path)) {
			pathPossible = true;
		}
		//down
		else if(solveMaze(maze, i+1, j, path)) {
			pathPossible = true;
		}
		//left
		else if(solveMaze(maze, i, j-1, path)) {
			pathPossible = true;
		}
		return pathPossible;
	}
}
