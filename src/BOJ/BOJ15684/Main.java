package BOJ.BOJ15684;

import java.util.Scanner;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ladder[a][b] = true;
        }

        dfs(0, 1, 1);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void dfs(int cnt, int x, int y) {
        if (cnt > 3) {
            return;
        }

        if (check()) {
            result = Math.min(result, cnt);
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = (i == x ? y : 1); j < N; j++) {
                if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) {
                    continue;
                }

                ladder[i][j] = true;
                dfs(cnt + 1, i, j);
                ladder[i][j] = false;
            }
        }
    }

    private static boolean check() {
        for (int start = 1; start <= N; start++) {
            int k = start;
            for (int h = 1; h <= H; h++) {
                if (ladder[h][k]) {
                    k++;
                } else if (k > 1 && ladder[h][k - 1]) {
                    k--;
                }
            }

            if (k != start) {
                return false;
            }
        }

        return true;
    }
}
