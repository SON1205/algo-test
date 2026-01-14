package BOJ.BOJ2156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }
        if (n == 2) {
            System.out.println(wine[1] + wine[2]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(
                            dp[i - 2] + wine[i],
                            dp[i - 3] + wine[i - 1] + wine[i]
                    )
            );
        }

        System.out.println(dp[n]);
    }
}

//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<Integer> cups = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            cups.add(sc.nextInt());
//        }
//
//        if (n == 1 || n == 2) {
//            int total = 0;
//            for (int cup : cups) {
//                total += cup;
//            }
//            System.out.println(total);
//            return;
//        }
//
//        int[][] dp = new int[n][2]; // 0: 선택O, 1: 선택X
//        dp[0][0] = cups.get(0);
//        dp[0][1] = 0;
//        dp[1][0] = cups.get(1) + dp[0][0];
//        dp[1][1] = dp[0][0];
//        for (int i = 2; i < n; i++) {
//            dp[i][0] = Math.max(dp[i - 2][1] + cups.get(i - 1), dp[i - 1][1]) + cups.get(i);
//            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//        }
//
//        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
//    }
//}
