package SWEA22683;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int result;
    static int[] dr = {-1, 0, 1, 0};//상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            result = Integer.MAX_VALUE;
            int N = sc.nextInt();
            int K = sc.nextInt();

            char[][] input = new char[N][];

            for (int i = 0; i < N; i++) {
                input[i] = sc.next().toCharArray();
            }

            boolean[][] visited = new boolean[N][N];

            boolean isDone = true;

            for (int i = 0; i < N; i++) {
                if (!isDone) {
                    break;
                }

                for (int j = 0; j < N; j++) {
                    if (input[i][j] != 'X') {
                        continue;
                    }

                    isDone = false;
                    visited[i][j] = true;
                    dfs(input, visited, i, j, K, 0, 0);
                    break;
                }
            }

            System.out.println("#" + tc + " " + (result == Integer.MAX_VALUE ? -1 : result));
        }
    }

    private static void dfs(char[][] input, boolean[][] visited, int r, int c, int K, int dir, int cnt) {
        if (input[r][c] == 'Y') {
            result = Math.min(result, cnt);

            System.out.println(result);
            for (int i = 0; i < input.length; i++) {
                System.out.println(Arrays.toString(visited[i]));
            }
            return;
        }

        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= input.length || nc >= input.length) {
                continue;
            }

            if (visited[nr][nc] || (K == 0 && input[nr][nc] == 'T')) {
                continue;
            }

            int tmp = Math.abs(i - dir) > 2 ? 1 : Math.abs(i - dir);

            if (input[nr][nc] == 'T') {
                visited[nr][nc] = true;
                dfs(input, visited, nr, nc, K - 1, i, cnt + 1 + tmp);
                visited[nr][nc] = false;
            } else {
                visited[nr][nc] = true;
                dfs(input, visited, nr, nc, K, i, cnt + 1 + tmp);
                visited[nr][nc] = false;
            }
        }
    }
}
