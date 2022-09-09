class findMedianSortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int c = 0;
        int len = nums1.length + nums2.length;
        int i= 0,j = 0;
        double res = 0;
        if(len % 2 != 0)
        {
            while(i < nums1.length && j < nums2.length && c != (len/2) + 1)
            {
                if(nums1[i] < nums2[j])
                {
                    res = nums1[i++];
                }
                else
                    res = nums2[j++];
                c++;
            }
            
            while( j < nums2.length && c != (len/2) + 1)
            {
                res = nums2[j++];
                c++;
            }
            
            while(i < nums1.length && c != (len/2) + 1)
            {
                res = nums1[i++];
                c++;
            }
        }
        else
        {
            while(i < nums1.length && j < nums2.length && c != (len/2))
            {
                if(nums1[i] < nums2[j])
                {
                    res = nums1[i++];
                }
                else
                    res = nums2[j++];
                c++;
            }
            
            while( j < nums2.length && c != (len/2))
            {
                res = nums2[j++];
                c++;
            }
            
            while(i < nums1.length && c != (len/2))
            {
                res = nums1[i++];
                c++;
            }
            
            
             if(i < nums1.length && j < nums2.length)
              if(nums1[i] < nums2[j])
                {
                    res = (res + nums1[i++])/2;
                }
                else
                    res = (res+ nums2[j++])/2;

            else if( j < nums2.length)
            res = (res+ nums2[j++])/2;

            else if(i < nums1.length)
            res = (res+ nums1[i++])/2;
        }
        
        return res;
    }
}