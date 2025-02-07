package practice;

public class T4_240911 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 每次从分割的两边选择边界值，两个小值，两个大值
            int m = nums1.length, n = nums2.length;
            if(m > n){
                return findMedianSortedArrays(nums2, nums1);
            }
            int left = 0, right = m;
            int media1 = 0, median2 = 0;
            while(left <= right){
                int i = (left + right) / 2;
                int j = (left + right + 1) / 2 - i;
                int numLeft1 = i - 1 < 0 ? Integer.MIN_VALUE : nums1[i - 1];
                int numRight1 = i == m ? Integer.MAX_VALUE : nums1[i];
                int numLeft2 = j - 1 < 0 ? Integer.MIN_VALUE : nums2[j - 1];
                int numRight2 = j == n ? Integer.MAX_VALUE : nums2[j];
                // 中值在左侧
                if(numLeft1 <= numRight2){
                    media1 = Math.max(numLeft1, numLeft2);
                    median2 = Math.min(numRight1, numRight2);
                    left = i + 1;
                }
                else {
                    right = i - 1;
                }
            }
            return (m + n) % 2 == 0 ? (double)(media1 + median2) / 2.0 : media1;
        }
    }

}
