class valid_pal {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s.trim();
        int i = 0, j = s.length() - 1;
        while(i<j)
        {
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            
            if((i<j && s.charAt(i) != (s.charAt(j))))return false;
            else
            {
                i++;
                j--;
            }
        }
        
        return true;
        
    }
}
