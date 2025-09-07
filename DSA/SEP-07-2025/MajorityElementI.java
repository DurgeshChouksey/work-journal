// https://leetcode.com/problems/majority-element/

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        // solution using boyre-morre
        int n = nums.length;

        // we have to find greater than n/2 occurences so only one candidate
        // becasue there can be only one element which can occur more than n/2 times
        int candidate = nums[0];
        int candidateCount = 1;

        for(int i : nums) {
            if(candidate == i) candidateCount++;
            else if(candidateCount == 1) candidate = i;
            else candidateCount--;
        }

        // verifying that the candidate with max votes is occuring more than n/2 or not
        // because there can be a most occuredn element which is not greater than n/2

        // --- verificatoin
        int count = 0;
        for(int i : nums) {
            if(i == candidate) count++;
        }

        if(count > n/2) return count;

        // --- but in the question it was guarrented that there is alwasy one element more than n/2
        // --- so the most voted element is always the manority element
        return candidateCount;
    }
}
