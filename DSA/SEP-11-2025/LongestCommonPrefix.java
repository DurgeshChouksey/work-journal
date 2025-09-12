// https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
        public String longestCommonPrefix(String[] strs) {
            //we will first assume the first string of strs as the prefix
            String prefix = strs[0];

            // then iterating over each string
            for(int i = 1; i<strs.length; i++) {
                // now we will comparte them with the first string
                // if their .indexOf(prefix) == -1, then their prifix is differnet
                // then we will remove last char with each iteration

                while(strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if(prefix.isEmpty()) return "";
                }
            }

            return prefix;
        }
}
