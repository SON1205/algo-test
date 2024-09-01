package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 2, 4, 20, 46, 33};
        int[] tmp = new int[arr.length];

        mergeSort(arr, tmp,0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, tmp, start, mid);
        mergeSort(arr, tmp, mid + 1, end);
        merge(arr, tmp, start, mid, end);
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        int L = start;
        int R = mid + 1;

        int idx = start;

        while (L <= mid && R <= end) {
            if (arr[L] < arr[R]) {
                tmp[idx++] = arr[L++];
            } else {
                tmp[idx++] = arr[R++];
            }
        }

        if (L <= mid) {
            for (int i = L; i <= mid; i++) {
                tmp[idx++] = arr[i];
            }
        } else {
            for (int i = R; i <= end; i++) {
                tmp[idx++] = arr[i];
            }
        }

        System.arraycopy(tmp, start, arr, start, end + 1 - start);
    }
}
