import java.util.*;

public class SortAnArray {

}

// https://leetcode.com/problems/sort-an-array/description/

class Solution {

    public static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;

        // find mid
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid+1;

        // temp array
        int[] sorted = new int[end-start+1];

        int k = 0;
        while(leftIndex<=mid && rightIndex<=end) {
            if(arr[leftIndex] < arr[rightIndex]) sorted[k++] = arr[leftIndex++];
            else sorted[k++] = arr[rightIndex++];
        }

        while(leftIndex <= mid) sorted[k++] = arr[leftIndex++];

        while(rightIndex <= end) sorted[k++] = arr[rightIndex++];

        // now put the sorted element into the original array
        for(int i = start; i<=end; i++) {
            arr[i] = sorted[i-start]; // because sorted is starting from zero
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
