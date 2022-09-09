import java.util.*;
public class maximalSquare {

    public static void main(String[] args) {
        System.out.println(maximalSquare(
        new char[][]
            {{'0','1'},{'1','0'}}
    ));
    }
        public static int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length+1][matrix[0].length+1];
            Arrays.fill(dp[0],0);
            for(int i = 0; i<matrix.length;i++) dp[i][0] = 0;
            int max = 0;
            for(int i = 1;i<=matrix.length;i++)
            {
                for(int j = 1; j<=matrix[0].length;j++)
                {
                    if(matrix[i-1][j-1] == '0') dp[i][j] = 0;
                    else
                  dp[i][j] = 1+Math.min(
                    dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j])
                  );

                  max = Math.max(max,dp[i][j]);
                }
            }
            return max*max;
            
        }
    }
