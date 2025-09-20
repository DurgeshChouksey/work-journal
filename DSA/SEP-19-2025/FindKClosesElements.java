// https://leetcode.com/problems/find-k-closest-elements/description/

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = k;

        while(r<n) {
            if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
                r++;
            } else if (Math.abs(arr[l] - x) == Math.abs(arr[r] - x)) {
                if(arr[l] == arr[r]) {
                    l++;
                    r++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = l; i<r; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
