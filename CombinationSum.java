import java.util.*;
public class CombinationSum {
    
    public static void main(String[] args) {
       System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new ArrayList<>(rec(new ArrayList<>(),new HashSet<>(),candidates,target,0));
    }
    
    
    public static Set<List<Integer>> rec( List<Integer> temp, Set<List<Integer>> res, int arr[],int target,int sum)
    {
        if(sum == target)
        {
            List<Integer> temp1 = new ArrayList<>(temp);
            Collections.sort(temp1);
            res.add(new ArrayList<>(temp1));
            return res;
        }
        
        for(int i = 1; i<arr.length;i++)
        {
            sum += arr[i];
            if(sum > target)
            {
                sum -= arr[i];
                continue;
            }
            temp.add(arr[i]);
            
            rec(temp,res,arr,target,sum);
            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            if(temp.size() == 0) sum = 0;
           
        }
        
        return res;
    }
}
