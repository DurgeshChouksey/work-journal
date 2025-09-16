// https://leetcode.com/problems/valid-palindrome-ii/description/

class Solution {

    public boolean validPalindrome1(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome1(s, left + 1, right) || validPalindrome1(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
}
