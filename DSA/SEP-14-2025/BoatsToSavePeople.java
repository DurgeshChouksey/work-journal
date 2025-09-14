// https://leetcode.com/problems/boats-to-save-people/description/

import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        while(left<=right) {

            if(left == right) {
                boats++;
                break;
            }

            if(people[left] + people[right] <= limit) {
                boats++;
                left++;
                right--;
            } else {
                boats++;
                right--;
            }
        }

        return 0;
    }
}
