package geeksforgeeks.five.backtracking;

import java.util.HashSet;

//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
public class RatInMaze {

    // 1  0  0  0
    // 1  1  0  0
    // 0  1  0  0
    // 0  1  1  1
    public static void main(String[] args) {
        RatInMaze rat = new RatInMaze();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        rat.solveMaze(maze);
    }

    int[] dx = {1, 0};
    int[] dy = {0, 1};
    int N = 0;

    void solveMaze(int[][] maze) {
        N = maze.length;
        int[][] sol = new int[N][N];
        HashSet<String> visited = new HashSet<>();

        sol[0][0] = 1;
        if (dfs(maze, 0, 0, sol, visited)) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    System.out.printf("%01d ", sol[x][y]);
                }
                System.out.println();
            }
        }
    }

    boolean dfs(int[][] maze, int x, int y, int[][] sol, HashSet<String> visited) {
        if (x == N - 1 && y == N - 1) return true;
        String tmp = x + "|" + y;
        if (visited.contains(tmp)) return false;
        visited.add(tmp);

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isSafe(nx, ny, maze)) {
                sol[nx][ny] = 1;
                if (dfs(maze, nx, ny, sol, visited)) return true;
                else sol[nx][ny] = 0;
            }
        }

        return false;
    }

    boolean isSafe(int nx, int ny, int[][] maze) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N && maze[nx][ny] == 1;
    }
}
