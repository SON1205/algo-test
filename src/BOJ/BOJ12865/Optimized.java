package BOJ.BOJ12865;

import java.util.Scanner;

public class Optimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();

            for (int j = k; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        System.out.println(dp[k]);
    }
}
