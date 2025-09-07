// https://leetcode.com/problems/majority-element-ii/submissions/1762425528/

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // Boyre-morre
        int n = nums.length;

        // now here we have to find more than n/3 occurence
        // and in an array there can be atmost 2 element can get occurrence more than n/3

        int candidate1 = 0;
        int candidate2 = 1;

        int candidateCount1 = 0;
        int candidateCount2 = 0;

        for(int i : nums) {
            if(i == candidate1) candidateCount1++;
            else if(i == candidate2) candidateCount2++;
            else if(candidateCount1 == 0) {
                // there can be two cases
                // fisrt -> it's the first candidate to get a vote
                // second -> there is some another candidate with same votes
                candidate1 = i;
            }
            else if(candidateCount2 == 0) candidate2 = i;
            else {
                candidateCount1--;
                candidateCount2--;
            }
        }

        // verifying
        // because it's not sure that the 2 candidate with most votes
        // are crosing the threhold of n/3 (bahumat)

        candidateCount1 = 0;
        candidateCount2 = 0;

        for(int i : nums) {
            if(i == candidate1) candidateCount1++;
            else if(i == candidate2) candidateCount2++;
        }


        List<Integer> ans = new ArrayList<>();

        // check
        if(candidateCount1 > n/3) ans.add(candidate1);
        if(candidateCount2 > n/3) ans.add(candidate2);

        return ans;
    }
}
