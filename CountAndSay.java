class CountAndSay {
    static String s,str;
    static int count;
    public static String countAndSay(int n) {
        if(n == 1) return "1";
        if(n==2) return "11";
        if(n == 3) return "21";
        if(n==4) return "1211";
      
        s = countAndSay(n-1);
        count = 1;
        str = "";
        int i = 0;
        for(; i<s.length() - 1;i++)
        {
            if(s.charAt(i) == s.charAt(i+1)) count++;
            else
            {
                str += ""+count + s.charAt(i);
                count = 1;
            }
        }
        str += ""+count + s.charAt(i);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}