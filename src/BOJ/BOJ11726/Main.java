package BOJ.BOJ11726;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] memo = new long[n];

        memo[0] = 1;

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                memo[i] = 2;
                continue;
            }

            // long 범위도 초과..
            memo[i] = (memo[i - 2] + memo[i - 1]) % 10_007;
        }

        System.out.println(memo[n - 1]);
    }
}
