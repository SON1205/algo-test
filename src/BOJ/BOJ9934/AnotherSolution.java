package BOJ.BOJ9934;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnotherSolution {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[] arr = new int[(1 << K) - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < K; i++) {
            result.add(new ArrayList<>());
        }

        go(arr, 0, arr.length, 0);

        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void go(int[] arr, int left, int right, int depth) {
        if (left > right) {
            return;
        }

        int mid = (left + right) / 2;
        result.get(depth).add(arr[mid]);

        if (left == mid) {
            return;
        }

        go(arr, left, mid - 1, depth + 1);
        go(arr, mid + 1, right, depth + 1);
    }
}
