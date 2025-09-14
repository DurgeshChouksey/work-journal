// https://leetcode.com/problems/container-with-most-water/description/

import java.util.*;

class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int currWaterLevel = 0;
            int maxWaterLevel = 0;

            while(left < right) {
                // area is length * height of the reactangle
                // lenght is simply right - left
                // and height is the min of height[left] && height[right];
                int area = (right - left) * Math.min(height[left], height[right]);
                currWaterLevel = area;
                maxWaterLevel = max(currWaterLevel, maxWaterLevel);

                if(height[left] <= height[right]) left++;
                else right--;
            }

            return maxWaterLevel;
        }
}
