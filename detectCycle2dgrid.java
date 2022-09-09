public class detectCycle2dgrid {
    
    private static boolean check = false;
    public static void main(String[] args) {
        System.out.println(containsCycle(new char[][]{{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}}));
    }
    public static boolean containsCycle(char[][] grid) {
    
    for(int i = 0;i<grid.length;i++)
        for(int j = 0; j<grid[0].length;j++)
        {
       try {
        if(dfs(i,j,grid,new boolean[grid.length][grid[0].length],-1)) check = true;
       }
       catch(Exception e){
        return check;
       }
    }
        return check;
    }
    
    public static boolean dfs(int i,int j, char[][] grid, boolean vis[][], int dir)
    {
        if(vis[i][j]) 
        {
            check = true;
           throw new ArithmeticException();
        }
        
        boolean up,down,left,right;
        
        vis[i][j] = true;
        
        up = i>0 && dir!=1 && grid[i-1][j] == grid[i][j] && dfs(i-1,j,grid,vis,0);
        
        down = i<grid.length - 1 && dir!=0 && grid[i+1][j] == grid[i][j] && dfs(i+1,j,grid,vis,1);
        
        left = j>0 && dir!=3 &&  grid[i][j-1] == grid[i][j] && dfs(i,j-1,grid,vis,2);
        
        right = j<grid[0].length - 1 && dir!=2 && grid[i][j+1] == grid[i][j] && dfs(i,j+1,grid,vis,3);
        
        return up || down || left || right;
    }
}