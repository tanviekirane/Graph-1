// BFS

class Solution{
public boolean hasPath(int[][] maze, int[] start, int[] destination){
	// null
	if(maze == null) return false;
	int m = maze.length; int n= maze[0].length;
	Queue<int[]> q = new LinkedList<>();
	q.add(start);
	maze[start[0]][start[1]] = 2;
	int[][] dirs = new int[][]{ {0,1}, {1,0}, {-1,0}, {0,-1} };
	while(!q.isEmpty()){
		int[] curr = q.poll();
		for(int [] dir: dirs){
			int i = curr[0]; int j= curr[1];
			while(i<m && j<n && i>=0 && j>=0 && maze[i][j] != 1){
			// here at bounds it goes to -1 and n so we have to bring it back
			i += dir[0]; 
			j += dir[1];
			}
			// come back one step!
			i -= dir[0];
			j -= dir[1];
			// wherever it stops
			if(maze[i][j] == 0){
				if(maze[i][j] == 0){
					if(i == destination[0] && j == destination[1]) return true;
					maze[i][j] = 2;
					q.add(new int[]{i,j});
				}
			}
		}	
	}
	return false;
	}
}

// ****************************************************

// DFS

class Solution{
int[][] dirs; int m; int n;
public boolean hasPath(int[][] maze, int[] start, int[] destination){
	// null
	if(maze == null) return false;
	m = maze.length; n= maze[0].length;
	dirs = new int[][]{ {0,1}, {1,0}, {-1,0}, {0,-1} };
	return dfs(maze, start, destination);
}
}

private boolean dfs(int[][] maze, int[] start, int[] destination){
// base
if(maze[start[0]][start[1]] == 2) return false;

// logic
if(start[0] == destination[0] && start[1] == destination[1]) return true;
// visited
maze[start[0]][start[1]] = 2;
for(int[] dir: dirs){
	int i = start[0]; int j = start[1];
	while(i<m && j<n && i>=0 && j>=0 && maze[i][j] != 1){
		i += dir[0];
		j += dir[1];
	}	
	// come back
	i -= dir[0];
	j -= dir[1];
	if(dfs(maze, new int[]{i,j}, destination)) return true;
}
return false;
}
}
