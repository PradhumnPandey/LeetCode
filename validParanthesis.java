import java.util.*;
public class validParanthesis {
    
    private static List<String> ls = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        rec("",3,3);

        return ls;
    }

    public static void rec(String s, int i, int j)
    {
        if(i < 0 || j < 0 || i>j) return;
        if( i == 0 && j == 0) ls.add(s);

        rec(s+"(", i - 1,j);
        rec(s+")",i,j-1);

    }
}
