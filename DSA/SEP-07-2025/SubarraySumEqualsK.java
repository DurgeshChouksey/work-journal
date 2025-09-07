// https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {

        // approach is very simple
        // we iterate over the whole array
        // and gonna add each element into a sum variable
        // and there will be a map which will store the frequency of each sum
        // like if sum = 10, we will store (10,1) in map, and if we ever again get's sum = 10 we will add (10,2)

        // logic here is, like if we have an array
        // 1,2,3,1,2,3,4


        // map will look like these
        // initially sum is 0 so (0,1), nums[0] = 1 (1,1) nums[1] = 2(3,1), nums[2] = 3(6,1)...
        // then we will check if (sum - k) ever existed in the array
        // like for nums[1] = 2, sum is 3, and (sum - k) (3-3) == 0,
        // (0,1) exist in the array so there is one subarray which have sum = 3
        // and yes nums[0](1) + nums[1](2) == k(3)

        // then for nums[2] = 3
        // sum = 6, and (sum - k = 3) and yes (3,1) exist in the array
        // so subarray becomes 2, and yes nums[2] = 3 = k;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int count = 0;
        int sum = 0;

        // for the first time sum is zero so add zero
        // because if we evern get sum - k as zero, that means, we found an subarray whose sum is k

        for(int i : nums) {
            sum += i;
            if(mp.containsKey(sum - k)) count += mp.get(sum - k);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
