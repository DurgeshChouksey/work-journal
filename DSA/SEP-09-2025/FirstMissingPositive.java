// https://leetcode.com/problems/first-missing-positive/description/

import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // first check if one is present in the array or not
        // if not than it's the smallest positive it's the answer

        boolean isOnePresent = false;
        for(int i : nums) {
            if(i == 1) isOnePresent = true;
        }
        if(!isOnePresent) return 1;


        // now we don't have to check for cases like nums[i]<=0 && nums[i] > n
        // because if it's less than or equal to n it's not a positive number
        // or if it's greater than n, than definately there is one number which is missing from 1-n
        // so we can make these valuse one because one is alerady present

        for(int i = 0; i<n; i++) {
            if(nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }


        // now the (nums as index) pattern logic
        // we will mark the values present, at their index - 1 as -ve
        // if all nevative meaning all number are present from 1-n, so answer is n+1
        // if anyone is positive meaning, i+1 is the answer

        for(int i = 0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1;
            // if already negative skip
            if(nums[index] > 0) nums[index] *= (-1);
        }


        // check
        for(int i = 0; i<n; i++) {
            if(nums[i] > 0) return i+1;
        }

        return n+1;
    }
}
