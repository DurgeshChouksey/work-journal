import java.util.*;


public class TopKFrequentElement {

}


// https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        // count frequency
        for(int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        // now we want to sort the the map by values
        // but we can't apply inbuilt Collections sort on map
        // and if we uses TreeMap, it will sort keys

        // so createa a list, with each map entry, and then sort it by value

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(mp.entrySet());

        // sorting entry by value in descending order
        entryList.sort((a,b) -> b.getValue() - a.getValue());

        // create a result array and store the values of top k entries from entryList
        int[] result = new int[k];
        for(int i = 0; i<k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}
