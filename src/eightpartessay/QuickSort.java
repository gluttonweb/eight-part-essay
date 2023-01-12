package eightpartessay;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        int base = arr[left];
        int i = left;
        int j = right;
        int lastIndex = left;
        while (i < j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                lastIndex = j;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
                lastIndex = i;
            }
        }
        if (lastIndex - 1 > left) {
            quickSort(arr, left, lastIndex - 1);
        }
        if (lastIndex + 1 < right) {
            quickSort(arr, lastIndex + 1, right);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEachOrdered(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }
}
