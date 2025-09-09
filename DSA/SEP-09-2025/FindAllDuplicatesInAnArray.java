// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/


import java.util.*;


class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // we will solve it using (nums as index) pattern
        // -> constraints for this patterns: values should be between 1-n
        // -> we will makre nums[nums[i]] as negative to acknowledge that nums[i] is present
        // -> if but for n, it will go out of bound
        // -> and we know values are from 1-n, so zero index is free
        // -> so we mark a nums[i] - 1 as negavite, like for 1 index 0, for 2 index 1 ... for n index n-1
        // -> and for finding index, we have to take abs values, because it's obvious that it has been marked -ve before
        for(int i = 0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= (-1);
            } else {
                result.add(index + 1);
            }
        }

        return result;
    }
}
