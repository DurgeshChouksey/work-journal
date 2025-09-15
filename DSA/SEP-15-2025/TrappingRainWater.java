// https://leetcode.com/problems/trapping-rain-water/description/

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while(left < right) {
            if(leftMax<=rightMax) {
                left++;
                int containerShouldBeLessThan = Math.min(leftMax, rightMax);
                int currentContainer = height[left];
                if(currentContainer < containerShouldBeLessThan) {
                    water += containerShouldBeLessThan - currentContainer;
                }
                // if the current container is greater than leftMax we have a new leftMax
                leftMax = Math.max(leftMax, currentContainer);
            } else {
                right--;
                int containerShouldBeLessThan = Math.min(leftMax, rightMax);
                int currentContainer = height[right];
                if(currentContainer < containerShouldBeLessThan) {
                    water += containerShouldBeLessThan - currentContainer;
                }
                // if the current container is greater than leftMax we have a new leftMax
                leftMax = Math.max(leftMax, currentContainer);
            }
        }
        return water;
    }
}
