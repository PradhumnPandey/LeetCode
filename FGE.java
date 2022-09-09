public class FGE {
    
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
        public static int maxArea(int[] h) {
            
            int fger[] = new int[h.length];
            int fgel[] = new int[h.length];
            int max = 0;
            int j = h.length - 1;
            for(int i = 0; i < h.length; i++)
            {
                j = h.length - 1;
                while(h[j] < h[i]) j--;
                    fger[i] = j;
            }
            
           
            for(int i = 0; i < h.length; i++)
            {
                max = Math.max(max, Math.abs(fgel[i] - fger[i]) * h[i]);
            }
            
            return max;
        }
}
