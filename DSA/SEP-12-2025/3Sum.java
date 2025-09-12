// https://leetcode.com/problems/3sum/
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();


        for(int i = 0; i<n-2; i++) {
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = n-1;

            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < 0) left++;
                else if(nums[i] + nums[left] + nums[right] > 0) right--;
                else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }


        return ans;
    }
}
