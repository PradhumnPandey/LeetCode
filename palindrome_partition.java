import java.util.*;
public class palindrome_partition {
    public static void main(String[] args) {
        
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ls = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Stack<String> st  = new Stack<>();
        q.add(s);
        st.push(s);
        String temp;
        for(int i = 0; i< s.length(); i++)
        {
           if(isPal(st))
           ls.add(new LinkedList<>(q));
           temp = st.pop();
           
        }
        return null;
    }

    public static boolean isPal(Queue<String> q)
    {
        boolean check = true;
        for(String s : q)
        {
            int i = 0, j = s.length();
            while(i<=j)
            if(s.charAt(i) != s.charAt(j))
            {
                check = false;
                break;
            } 
            
        }
        return check;
    }

    public static boolean isPal(Stack<String> q)
    {
        boolean check = true;
        for(String s : q)
        {
            int i = 0, j = s.length();
            while(i<=j)
            if(s.charAt(i) != s.charAt(j))
            {
                check = false;
                break;
            } 
            
        }
        return check;
    }
}
