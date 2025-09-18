// https://leetcode.com/problems/permutation-in-string/description/

import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        for(char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] windowFreq = new int[26];
        while(right < s2.length()) {
            windowFreq[s2.charAt(right) - 'a']++;

            if((right - left + 1) == s1.length()) {
                if(Arrays.equals(s1Freq, windowFreq)) return true;
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }
        return false;
    }
}
