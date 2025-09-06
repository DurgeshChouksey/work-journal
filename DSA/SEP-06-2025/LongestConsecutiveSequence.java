import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int seq = 1;
        int longestSeq = 1;

        for(int i = 1; i<n; i++) {
            if(nums[i-1] == nums[i] - 1) seq++;
            else if(nums[i-1] == nums[i]) continue;
            else {
                longestSeq = Math.max(longestSeq, seq);
                seq = 1;
            }
        }

        longestSeq = Math.max(longestSeq, seq);
        return longestSeq;
    }
}
