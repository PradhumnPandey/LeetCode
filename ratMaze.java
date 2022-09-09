//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class ratMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Sol obj = new Sol();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Sol {
    static ArrayList<String> res;
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        res = new ArrayList<>();
        dfs(0,0,0,m,"");
        return res;
    }
    
    public static void dfs(int i,int j,int dir, int[][]arr, String s)
    {
         if(i == 3 && j == 3)
         {
             res.add(s);
             return;
         }
         
         arr[i][j] = 0;
         
         
         //UP
         if(i > 0 && arr[i-1][j] == 1 && dir != 2)
            dfs(i-1,j,1,arr,s+"U");
             
         //left
         if(j > 0 && arr[i][j-1] == 1  && dir!=4)
            dfs(i,j-1,3,arr,s+"L");

         //down
         if(i < 3  && arr[i+1][j] == 1 && dir!=1)
             dfs(i+1,j,2,arr,s+"D");
             
         //Right
         if(j < 3  && arr[i][j+1] == 1 && dir!=3)
            dfs(i,j+1,4,arr,s+"R");
            
        arr[i][j] = 1;
    }
}