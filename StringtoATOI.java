public class StringtoATOI {
    
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
    }
    public static int myAtoi(String s) {
        int sign = 1;
        double num = 0;
        int dig = 0;
        s = s.trim();
        for(int i = 0; i<s.length();i++)
        {
            if(num*sign >= 2147483647) return 2147483647;
            if(num*sign <= -2147483648) return -2147483648;
            if( i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            {
                if(s.charAt(i) == '-') sign = -1;
                continue;
            }
            dig = (int)s.charAt(i);
            if(dig > 57 || dig < 48 ) return (int)num*sign;
            else
            {
                num = num*10 + dig - 48;
            }
        }
        return (int)num*sign;
    }
}
