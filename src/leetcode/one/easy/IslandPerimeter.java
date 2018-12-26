package leetcode.one.easy;

//https://leetcode.com/problems/island-perimeter/
public class IslandPerimeter {

    public static void main(String[] args) {
        IslandPerimeter o = new IslandPerimeter();

        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        System.out.println(o.islandPerimeter(grid)); //16
    }

    public int islandPerimeter(int[][] grid) {
        int island = 0;
        int neighbor = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    island++;
                    if (col < grid[0].length - 1 && grid[row][col + 1] == 1) neighbor++;
                    if (row < grid.length - 1 && grid[row + 1][col] == 1) neighbor++;
                }
            }
        }

        return 4 * island - 2 * neighbor;
    }
}
