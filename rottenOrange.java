import java.util.*;
class Pair
{
    int col,row,minute;
    Pair(int row, int col, int minute)
    {
        this.col = col;
        this.row = row;
        this.minute = minute;
    }
}
class rottenOrange {

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    public static int orangesRotting(int[][] nums) {
        Queue<Pair> q = new LinkedList<>();
        int minute = 0,i = 0,j = 0,oranges = 0,count = 0;
        for(i = 0; i<nums.length;i++)
        {
        for(j = 0;j<nums[0].length;j++)
        {
            if(nums[i][j] == 2) 
            {
                q.add(new Pair(i,j,0));
            }
            if(nums[i][j] == 1) oranges++;
        }
        }

        q.add(null);
        
        while(count < oranges && !q.isEmpty())
        {
            Pair temp = q.poll();
            i = temp.row;
            j = temp.col;
            
            //UP
            if(i > 0 && nums[i-1][j] == 1)
            {
               q.add(new Pair(i-1,j,minute));
                nums[i-1][j] = 2;
                count++;
            }
            
            //Down
            if(i < nums.length - 1&& nums[i+1][j] == 1)
            {
                q.add(new Pair(i+1,j,minute));
                nums[i+1][j] = 2;
                count++;
            }
            
            //Left
            if(j > 0 && nums[i][j-1] == 1)
            {
               q.add(new Pair(i,j-1,minute));
                nums[i][j-1] = 2;
                count++;
            }
            
            //Right
            if(j < nums[0].length- 1 && nums[i][j+1] == 1)
            {
                q.add(new Pair(i,j+1,minute));
                nums[i][j+1] = 2;
                count++;
            }
            
            if(q.peek() == null)
            {
                minute++;
                q.poll();
                if(q.isEmpty()) break;
                q.add(null);
            }
    
        }

        if(count < oranges) return -1;
        return minute;
            
    }
}