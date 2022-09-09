import java.util.*;
public class CombSum {
    
    static Set<List<Integer>> ls;
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1,2}, 4).toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ls = new HashSet<>();
        Arrays.sort(candidates);
        for(int i = 0; i<candidates.length;i++)
        rec(candidates,target,i,new ArrayList<>(),0);

        List<List<Integer>> res = new ArrayList<>();
        res.addAll(ls);
        return res;
    }
    
    public static void rec(int[] arr, int target,int i,List<Integer> temp, int sum)
    {
        if(i == arr.length) return;
        if(sum == target)
        {
            Collections.sort(temp);
            ls.add(new ArrayList<>(List.copyOf(temp)));
        }
        
        if(sum+arr[i] <= target)
        {
            temp.add(arr[i]);
            sum+=arr[i];
            rec(arr,target,i,temp,sum);
            temp.remove(temp.size() - 1);
            rec(arr,target,i+1,temp,sum - arr[i]);
        }
    }
}