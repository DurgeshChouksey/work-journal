// https://leetcode.com/problems/valid-anagram/description/

class Solution {
    public boolean isAnagram(String s, String t) {

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(char ch : s.toCharArray()) {
            freqS[ch - 'a']++;
        }

        for(char ch : t.toCharArray()) {
            freqT[ch - 'a']++;
        }

        for(int i = 0; i<26; i++) {
            if(freqS[i] != freqT[i]) return false;
        }

        return true;
    }
}
