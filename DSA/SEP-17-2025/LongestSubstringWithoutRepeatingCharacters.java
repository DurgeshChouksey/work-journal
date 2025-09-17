// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(right < s.length()) {
            if(mp.containsKey(s.charAt(right))) {
                left = Math.max(left, mp.get(s.charAt(right) + 1));
            }

            mp.put(s.charAt(right), right);

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }
}
