import java.util.*;
public class islandPermeter {
    
    public static void main(String[] args) {
       System.out.println(islandPerimeter(new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

    public static int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0; i<grid.length;i++)
        {
            for(int j = 0 ; j<grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    res += dfs(grid, i+1, j) +dfs(grid, i, j+1) + dfs(grid, i-1, j) + dfs(grid, i, j-1) ;
                }
            }
        }
        return res;
    }

    public static int dfs(int[][] grid, int i, int j)
    {
        if(i < 0 || j<0 || i>grid.length - 1 || j > grid[0].length -1 || grid[i][j] == 0) return 1;
        return 0;
    }

    
}
