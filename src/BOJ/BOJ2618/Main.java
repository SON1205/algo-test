package BOJ.BOJ2618;

import java.util.Scanner;

public class Main {
    static int N, W;
    static int[][] incidents;
    static int[][] dp;
    static int[][] choice; // 1 or 2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();

        incidents = new int[W + 1][2];
        for (int i = 1; i <= W; i++) {
            incidents[i][0] = sc.nextInt();
            incidents[i][1] = sc.nextInt();
        }
        dp = new int[W + 1][W + 1];
        choice = new int[W + 1][W + 1];

        // 초기화
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        int answer = solve(0, 0);
        System.out.println(answer);

        // 경로 추적
        trace(0, 0);
    }

    // DP
    static int solve(int i, int j) {
        if (Math.max(i, j) == W) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int next = Math.max(i, j) + 1;

        // 경찰차 1이 next 처리
        int dist1 = distance(1, i, next);
        int cost1 = solve(next, j) + dist1;

        // 경찰차 2가 next 처리
        int dist2 = distance(2, j, next);
        int cost2 = solve(i, next) + dist2;

        if (cost1 < cost2) {
            dp[i][j] = cost1;
            choice[i][j] = 1;
        } else {
            dp[i][j] = cost2;
            choice[i][j] = 2;
        }

        return dp[i][j];
    }

    // 거리 계산
    static int distance(int car, int from, int to) {
        int x1, y1;

        if (from == 0) {
            if (car == 1) {
                x1 = 1;
                y1 = 1;
            } else {
                x1 = N;
                y1 = N;
            }
        } else {
            x1 = incidents[from][0];
            y1 = incidents[from][1];
        }

        int x2 = incidents[to][0];
        int y2 = incidents[to][1];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // 경로 출력
    static void trace(int i, int j) {
        if (Math.max(i, j) == W) {
            return;
        }

        int next = Math.max(i, j) + 1;

        if (choice[i][j] == 1) {
            System.out.println(1);
            trace(next, j);
        } else {
            System.out.println(2);
            trace(i, next);
        }
    }
}
