// https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        // Count the frequency of each character in string t
        int[] freqT = new int[128]; // Supports both lowercase and uppercase letters
        for (char ch : t.toCharArray()) freqT[ch]++;

        // Count how many unique characters in t need to be matched
        int required = 0;
        for (int i : freqT) if (i > 0) required++;

        // Frequency of characters in the current window
        int[] freqWindow = new int[128];

        // Number of unique characters matched so far
        int found = 0;

        int left = 0, right = 0;
        int start = 0, minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            // Add the current character to the window frequency
            freqWindow[s.charAt(right)]++;

            // If this character is in t and its frequency matches, increase 'found'
            if (freqT[s.charAt(right)] > 0 && freqWindow[s.charAt(right)] == freqT[s.charAt(right)]) {
                found++;
            }

            // If all required characters are matched
            while (left <= right && found == required) {
                // Update minimum window length and starting index
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Shrink the window from the left
                freqWindow[s.charAt(left)]--;
                // If this character was part of t and now falls short, decrease 'found'
                if (freqT[s.charAt(left)] > 0 && freqWindow[s.charAt(left)] < freqT[s.charAt(left)]) {
                    found--;
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
