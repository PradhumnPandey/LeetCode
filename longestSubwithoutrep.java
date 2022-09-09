import java.util.*;
public class longestSubwithoutrep {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        return rec(s,0,s.length() - 1);
    }
    
    public static int rec(String s, int i, int j)
    {
        if(i == s.length() - 1 || j == 0 || i>j) return 1;
        
        if(check(s,i,j)) return s.length();
        
        return Math.max(rec(s,i+1,j) , rec(s,i,j-1));
        
    }
    
    public static boolean check(String s, int i , int j)
    {
        Map<Character,Integer> m = new HashMap<>();
        
        for(; i <= j; i++)
        {
            if(m.containsKey(s.charAt(i))) return false;
            else m.put(s.charAt(i) , 1);
        }
        return true;
    }
}
