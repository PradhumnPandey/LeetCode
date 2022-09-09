import java.util.*;
public class nQueens {

    public static void main(String[] args) {
        solveNQueens(4);
    }
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] i: board)
            Arrays.fill(i,'.');
        List<List<String>> res = new ArrayList<>();
        int col = 0,i = 0;
        List<String> temp = new ArrayList<>();
        while(col < n)
        {
            solve(board,col, 0, n);
            col = i+1;
        }
        
        
    }
    
    public static boolean safe(char[][] board,int i, int j,int n)
    {
        int k = i,l = j;
        
        while(i>0 && j>0)
            if(board[--i][--j] =='Q') return false;
        
        i = k; j = l;
        
          while(j>0)
            if(board[i][--j] =='Q') return false;
        
        i = k; j = l;
        
        while(i<n-1 && j > 0)
            if(board[++i][--j] =='Q') return false;
        
        return true;
    }
    
    public static void solve(char board[][], int col, int row, int n)
    {
        if(col == n)
        {
            int i;
            return;
        }
        for(;row < n;row++)
        if(safe(board,row,col,n))
        {
            board[row][col] = 'Q';
            solve(board, col+1, row, n);
            board[row][col] = '.';
        }
    }
    
    
}
