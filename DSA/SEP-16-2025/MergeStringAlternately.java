// https://leetcode.com/problems/merge-strings-alternately/description/


class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int j = 0;
        // if ans is a string, s+= word1.charAt(i)
        // will gonna take o(n^2) because strings are immutable
        // so it will create a new copy and then put the new char at last
        // so use StringBulder mutable
        while(i<word1.length() && j<word2.length()) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        while(i<word1.length()) {
            ans.append(word1.charAt(i++));
        }
        while(j<word2.length()) {
            ans.append(word2.charAt(j++));
        }
        return ans.toString();
    }
}
