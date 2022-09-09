import java.util.*;
public class maxNonNegNum {
    public static void main(String[] args) {
        System.out.println(maxset(new int[]{1,2,5,-1,2,5}));
    }
    public static ArrayList<Integer> maxset(int[] arr) {
        // int[] arr = new int[A.size()];
        // int j = 0;
        // for(int i : A) arr[j++] = i;
        
        int temp[] = new int[3];
        int i = 0,sum = arr[0];
        for(int j = 1; j<arr.length; j++)
         {
             if(arr[j] > 0)
                sum += arr[j];
            else
            {
                if(temp[2] < sum)
                {
                    temp[0] = i;
                    temp[1] = j-1;
                    temp[2] = sum;
                }
                i = j+1;
                sum = 0;
            }
         }
         ArrayList<Integer> res = new ArrayList<>();
         while(temp[0] <= temp[1])
         res.add(arr[i++]);
         
         return res;
    }
}
