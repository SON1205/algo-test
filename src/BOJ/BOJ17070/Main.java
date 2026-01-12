package BOJ.BOJ17070;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = (sc.nextInt() == 0);
            }
        }

        long[][][] dp = new long[N][N][3];

        // 시작 상태: (0,0)-(0,1) 가로, 끝점 (0,1)
        dp[0][1][0] = 1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!map[r][c]) {
                    continue; // 벽이면 스킵
                }

                // 1) 가로로 끝나는 경우 (r,c)
                // 이전이 가로 or 대각선이고, (r,c-1)에서 (r,c)로 가로 이동
                if (c - 1 >= 0 && map[r][c - 1]) {
                    dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
                }

                // 2) 세로로 끝나는 경우 (r,c)
                // 이전이 세로 or 대각선이고, (r-1,c)에서 (r,c)로 세로 이동
                if (r - 1 >= 0 && map[r - 1][c]) {
                    dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];
                }

                // 3) 대각선으로 끝나는 경우 (r,c)
                // 이전이 가로/세로/대각선이고, (r-1,c-1)에서 (r,c)로 대각 이동
                // 대각 이동은 (r,c), (r-1,c), (r,c-1) 3칸이 모두 빈 칸이어야 함
                if (r - 1 >= 0 && c - 1 >= 0
                        && map[r - 1][c] && map[r][c - 1] && map[r][c]) {
                    dp[r][c][2] += dp[r - 1][c - 1][0]
                            + dp[r - 1][c - 1][1]
                            + dp[r - 1][c - 1][2];
                }
            }
        }

        long ans = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(ans);
    }
}
