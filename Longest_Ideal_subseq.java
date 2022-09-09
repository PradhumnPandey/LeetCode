public class Longest_Ideal_subseq {
    
    public static void main(String[] args) {
        //System.out.println(check("abc", 1));
      System.out.println(longestIdealString("pvjcci", 4));
    }

    public static int longestIdealString(String str, int k) {
        StringBuffer s = new StringBuffer(str);
        return rec(s,k,0);
    }

    public static int rec(StringBuffer s1, int k, int i)
    {
       if(i == s1.length())return 0;
       if(check(s1, k)) return s1.length();
       
        StringBuffer s = new StringBuffer(s1);
       return Math.max(rec(s1.replace(i, i+1, ""),k,i),rec(s,k,i+1));
    }

    public static boolean check(StringBuffer s, int k)
    {
        int x = (int)s.charAt(0);
        for(int i = 0; i<s.length();i++)
        {
            if(Math.abs((int)s.charAt(i)) - x > k) return false;
            x = (int)s.charAt(i);
        }
        return true;
    }
}
