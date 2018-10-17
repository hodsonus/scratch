import java.util.*;

public class MazeSolver {

	public static void main(String[] args) {

		MazeSolver maze = new MazeSolver();

			char[][] grid = { {'O', 'S', 'X', 'X', 'X', 'X'},
							  {'O', 'X', 'O', 'O', 'O', 'F'},
							  {'O', 'X', 'O', 'X', 'X', 'X'},
							  {'O', 'O', 'O', 'O', 'O', 'X'},
							  {'X', 'O', 'X', 'X', 'O', 'X'},
							  {'X', 'O', 'X', 'X', 'X', 'X'}
		};

		System.out.println("Grid:");
		StringBuilder line;
		for (int i = 0; i < grid.length; i++) {
			line = new StringBuilder();
			for (int j = 0; j < grid[i].length; j++) {
				line.append(grid[i][j] + " ");
			}
			System.out.println( line.toString().trim() );
		}

		System.out.println("\n");

		List<Point> solution = maze.solver(grid);
		if (solution == null) {
			System.out.println("No solution...");
		}
		else {
			System.out.println("Solution:");
			for (int i = 0; i < grid.length; i++) {
				line = new StringBuilder();
				for (int j = 0; j < grid[i].length; j++) {
					if (solution.contains(new MazeSolver.Point(i,j))) {
						line.append('*' + " ");
					}
					else {
						line.append(grid[i][j] + " ");
					}
				}
				System.out.println( line.toString().trim() );
			}
		}
	}

	public List<Point> solver(char[][] grid) {

		int i = -1, j = -1;
		for (i = 0; i < grid.length; i++) {
			for (j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'S') {
					Point s = new Point(i,j);
					Stack<Point> traversal = new Stack<Point>();
					if (solverHelper(grid, s, traversal, new ArrayList<Point>())) {
						return new ArrayList(traversal);
					}
				}
			}
		}

		return null;
	}

	private boolean solverHelper(char[][] grid, Point s, Stack<Point> traversal, List<Point> visited) {
		if (grid[s.x][s.y] == 'F') {
			return true;
		}
		visited.add(s);
		List<Point> validNeighbors = getValidNeighbors(grid, s, visited);
		for (Point p : validNeighbors) {
			traversal.push(p);
			if (solverHelper(grid, p, traversal, visited)) return true;
			traversal.pop();
		}
		return false;
	}

	private List<Point> getValidNeighbors(char[][] grid, Point p, List<Point> visited) {

		List<Point> validNeighbors = new ArrayList<Point>();
		List<Point> possibleMutations = new ArrayList<Point>(Arrays.asList(new Point(-1,  0), 
																		   new Point( 1,  0),
																		   new Point( 0, -1),
																		   new Point( 0,  1)));

		int i, j;
		for (Point m : possibleMutations) {
			i = m.x;
			j = m.y;

			Point v = new Point(p.x+i, p.y+j);
			if (isValidIndex(grid, v) && grid[v.x][v.y] != 'X' && !visited.contains(v)) {
				validNeighbors.add(v);
			}
		}

		return validNeighbors;
	}

	private boolean isValidIndex(char[][] grid, Point v) {

		return (v.x >= 0 && v.x < grid.length) && (v.y >= 0 && v.y < grid[v.x].length);
	}

	private static class Point {

		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
		    if (obj instanceof Point) {
		      Point v = (Point) obj;
		      return this.x == v.x && this.y == v.y;
		    }
		    return false;
		}

		@Override
		public int hashCode() {

			//Cantor pairing function
			return (x+y)*(x+y+1)/2+y;
		}
	}
}