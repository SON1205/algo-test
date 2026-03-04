package BOJ.BOJ1446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();

        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (int j = 0; j < N; j++) {
                if (arr[j][0] == i && arr[j][1] <= D) {
                    dp[arr[j][1]] = Math.min(dp[arr[j][1]], dp[i] + arr[j][2]);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
