package BOJ.BOJ2109;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();

            arr[i][0] = d;
            arr[i][1] = p;
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] memo = new int[10_001];
        for (int i = 0; i < n; i++) {
            if (memo[arr[i][0]] == 0) {
                memo[arr[i][0]] = arr[i][1];
                continue;
            }

            int minIdx = 1;
            int minVal = memo[1];
            for (int j = 2; j <= arr[i][0]; j++) {
                if (minVal > memo[j]) {
                    minIdx = j;
                    minVal = memo[j];
                }
            }

            if (memo[minIdx] < arr[i][1]) {
                memo[minIdx] = arr[i][1];
            }
        }

        int sum = 0;
        for (int i : memo) {
            sum += i;
        }

        System.out.println(sum);
    }
}
