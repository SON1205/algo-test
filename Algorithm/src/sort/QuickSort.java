package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 2, 4, 20, 46, 33};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];

        int L = start + 1;
        int R = end;

        while (L <= R) {
            while (L <= R && arr[L] <= pivot) {
                L++;
            }

            while (arr[R] > pivot) {
                R--;
            }

            if (L < R) {
                int tmp = arr[L];
                arr[L] = arr[R];
                arr[R] = tmp;
            }
        }

        int tmp = arr[start];
        arr[start] = arr[R];
        arr[R] = tmp;

        return R;
    }
}
