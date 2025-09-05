import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);

        int prefix = nums[0];
        for(int i = 1; i<n; i++) {
            ans[i] *= prefix;
            prefix *= nums[i];
        }

        int suffix = nums[n-1];
        for(int i = n-2; i>=0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}
