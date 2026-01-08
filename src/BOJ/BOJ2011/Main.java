package BOJ.BOJ2011;

import java.util.Scanner;

public class Main {
    private static final int MOD = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] dp = new int[input.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= input.length(); i++) {
            int now = input.charAt(i - 1) - '0';
            if (now >= 1 && now <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            if (i == 1) {
                continue;
            }

            int prev = input.charAt(i - 2) - '0';
            if (prev == 0) {
                continue;
            }

            int value = prev * 10 + now;
            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[input.length()]);
    }
}
