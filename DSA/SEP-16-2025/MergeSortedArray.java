// https://leetcode.com/problems/merge-sorted-array/description/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int nums1Index = 0;
        int nums2Index = 0;
        int ansIndex = 0;
        while(nums1Index < m && nums2Index < n) {
            if(nums1[nums1Index] <= nums2[nums2Index]) {
                ans[ansIndex++] = nums1[nums1Index++];
            } else {
                ans[ansIndex++] = nums2[nums2Index++];
            }
        }

        while(nums1Index<m) {
            ans[ansIndex++] = nums1[nums1Index++];
        }

        while(nums2Index<n) {
            ans[ansIndex++] = nums2[nums2Index++];
        }

        for(int i = 0; i<m+n; i++) {
            nums1[i] = ans[i];
        }
    }
}
