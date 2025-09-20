// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums.length == 0) return false;
        if(k == 0) return false;

        HashSet<Integer> st = new HashSet<>();

        int left = 0;
        int right = 0;

        while(right < nums.length) {
            if(st.contains(nums[right]) && right - left <= k) {
                return true;
            }

            if(right - left + 1 > k) {
                st.remove(nums[left]);
                left++;
            }

            st.add(nums[right]);
            right++;
        }

        return false;
    }
}
