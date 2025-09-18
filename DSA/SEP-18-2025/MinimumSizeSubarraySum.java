// https://leetcode.com/problems/minimum-size-subarray-sum/description/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < n) {
            sum += nums[right];

            while(sum >= target) {
                minLen = Math.min(right-left+1, minLen);
                sum -= nums[left++];
            }

            right++;
        }

        if(minLen == Integer.MAX_VALUE) minLen = 0;

        return minLen;
    }
}
