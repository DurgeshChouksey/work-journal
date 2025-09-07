// https://neetcode.io/problems/string-encode-and-decode?list=neetcode250

import java.util.*;

public class EncodeDecodeString {

}

class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') j++;

            // now find the length
            int length = Integer.parseInt(str.substring(i, j));

            // skip '#'
            j++;

            String word = str.substring(j, j+length);
            ls.add(word);

            i = j+length;
        }
        return ls;
    }
}
