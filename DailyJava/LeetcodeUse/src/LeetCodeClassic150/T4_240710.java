package LeetCodeClassic150;

public class T4_240710 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            // 保证数组1的长度更短
            if(m > n){
                return findMedianSortedArrays(nums2, nums1);
            }
            int minIndex = 0, maxIndex = m;
            while(minIndex <= maxIndex){
                int i = (minIndex + maxIndex) / 2;
                int j = (m + n + 1) / 2 - i;
                if(j != 0 && i != m && nums2[j-1] > nums1[i]){
                    minIndex = i + 1;
                }
                else if(i != 0 && j != n && nums1[i -1] > nums2[j]){
                    maxIndex = i - 1;
                }
                else {
                    int maxLeft = 0;
                    if(i == 0){
                        maxLeft = nums2[j - 1];
                    }
                    else if(j == 0) {
                        maxLeft = nums1[i - 1];
                    }
                    else {
                        maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                    }
                    if((m + n) % 2 == 1){
                        return maxLeft;
                    }
                    int minRight = 0 ;
                    if( i == m){
                        minRight = nums2[j];
                    }
                    else if(j == n){
                        minRight = nums1[i];
                    }
                    else {
                        minRight = Math.min(nums2[j], nums1[i]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }

}
