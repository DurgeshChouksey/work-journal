import java.util.*;

public class SortColor {

}


// https://leetcode.com/problems/sort-colors/description/

class Solution {

    public void merge(int[] arr, int start, int mid, int end) {
        int[] sorted = new int[end - start + 1];
        int left = start;
        int right = mid+1;

        int k = 0;
        while(left <= mid && right <= end) {
            if(arr[left] <= arr[right]) sorted[k++] = arr[left++];
            else sorted[k++] = arr[right++];
        }

        while(left <= mid) {
            sorted[k++] = arr[left++];
        }

        while(right <= end) {
            sorted[k++] = arr[right++];
        }

        for(int i = start; i<=end; i++) {
            arr[i] = sorted[i - start];
        }
    }

    public void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }


    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
}
