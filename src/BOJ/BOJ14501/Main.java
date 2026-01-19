package BOJ.BOJ14501;

import java.util.Scanner;

public class Main {
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        go(arr, 0, 0);

        System.out.println(result);
    }

    private static void go(int[][] arr, int idx, int tmp) {
        if (idx == arr.length) {
            result = Math.max(result, tmp);
            return;
        }

        if (idx + arr[idx][0] - 1 < arr.length) {
            go(arr, idx + arr[idx][0], tmp + arr[idx][1]);
        }
        go(arr, idx + 1, tmp);
    }
}

/**
 * public class Main { public static void main(String[] args) { Scanner sc = new Scanner(System.in); int N =
 * sc.nextInt();
 * <p>
 * int[] T = new int[N]; int[] P = new int[N];
 * <p>
 * for (int i = 0; i < N; i++) { T[i] = sc.nextInt(); P[i] = sc.nextInt(); }
 * <p>
 * int[] dp = new int[N + 1]; // dp[N] = 0
 * <p>
 * for (int i = N - 1; i >= 0; i--) { if (i + T[i] <= N) { dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]); } else {
 * dp[i] = dp[i + 1]; } }
 * <p>
 * System.out.println(dp[0]); } }
 */
