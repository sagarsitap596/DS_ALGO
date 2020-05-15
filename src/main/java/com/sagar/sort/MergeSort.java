package com.sagar.sort;

/***
 * 
 * @author sitapsha
 * 
 * 
 * 
 *         As merge sort is a recursive algorithm, the time complexity can be
 *         expressed as the following recursive relation: T(n) = 2T(n/2) +
 *         O(n)<br>
 *         2T(n/2) corresponds to the time required to sort the sub-arrays and
 *         O(n) time to merge the entire array. When solved, the time complexity
 *         will come to O(nLogn).<br>
 *         This is true for the worst, average and best case since it will
 *         always divide the array into two and then merge. The space complexity
 *         of the algorithm is O(n) as we're creating temporary arrays in every
 *         recursive call.
 *
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[] { 3, 7, 2, 5, 2, 7, 4, 8, 5, 9, 7, 9, 10 }; // 13 >> 12
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void mergeSort(int[] a) {

        int n = a.length;

        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid]; // left array size
        int[] r = new int[n - mid]; // remaining size will be right array size

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        // Without using j
//        for (int i = mid; i < n; i++) {
//            r[i - mid] = a[i];
//        }

        for (int j = 0, i = mid; i < n; i++, j++) {
            r[j] = a[i];
        }

        mergeSort(l);
        mergeSort(r);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left_size, int right_size) {

        int i = 0, j = 0, k = 0;
        while (i < left_size && j < right_size) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left_size) {
            a[k++] = l[i++];
        }
        while (j < right_size) {
            a[k++] = r[j++];
        }
    }
}