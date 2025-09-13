// https://leetcode.com/problems/4sum/description/


import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i<n-3; i++) {
            if(i>0 && nums[i-1] == nums[i]) continue;
            for(int j = i+1; j<n-2; j++) {
                if(j>i+1 && nums[j-1] == nums[j]) continue;
                int l = j+1;
                int r = n-1;
                while(l<r) {
                    long sum = 1L * nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum < target) l++;
                    else if(sum > target) r--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l<r && nums[l-1] == nums[l]) l++;
                        while(l<r && nums[r+1] == nums[r]) r--;
                    }
                }
            }
        }

        return result;
    }
}
