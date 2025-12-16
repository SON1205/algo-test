package BOJ.BOJ2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dis = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dis[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1, dis, dp));
    }

    public static int tsp(int cur, int visited, int[][] dis, int[][] dp) {
        if (visited == dp[0].length - 1) {
            return dis[cur][0] == 0 ? INF : dis[cur][0];
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        int min = INF;
        for (int i = 0; i < dis.length; i++) {
            if ((visited & (1 << i)) != 0 || dis[cur][i] == 0) {
                continue;
            }

            int next = visited | (1 << i);
            min = Math.min(min, tsp(i, next, dis, dp) + dis[cur][i]);
        }

        dp[cur][visited] = min;
        return dp[cur][visited];
    }
}
