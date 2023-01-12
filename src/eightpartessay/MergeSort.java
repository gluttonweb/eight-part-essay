package eightpartessay;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        int[] newArr = new int[arr.length];
        sort(arr, left, right, newArr);
    }

    public static void sort(int[] arr, int left, int right, int[] newArr) {
        if (right - left < 1) { // 只剩1个，do nothing

        } else if (right - left == 1) { // 剩2个，排序
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
        } else { // 大于2个，递归拆分后排序合并
            int mid = (right + left) / 2;
            sort(arr, left, mid, newArr);
            sort(arr, mid + 1, right, newArr);
            merge(arr, left, right, mid, newArr);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid, int[] newArr) {
        int i = left;
        int j = mid + 1;
        int k = left;
        boolean flag = false;
        while (k <= right) {
            if (j > right) {
                if (flag) {
                    i++;
                }
                newArr[k] = arr[i];
                flag = true;
            } else {
                if (i <= mid && arr[i] <= arr[j]) {
                    newArr[k] = arr[i];
                    i++;
                } else {
                    newArr[k] = arr[j];
                    j++;
                }
            }
            k++;
        }
        for (int l = left; l <= right; l++) {
            arr[l] = newArr[l];
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 1, 9, 3, 7, 2, 6};
//        System.out.println(arr);
        mergeSort(arr);
        Arrays.stream(arr).forEachOrdered(value -> System.out.println(value));
    }
}
