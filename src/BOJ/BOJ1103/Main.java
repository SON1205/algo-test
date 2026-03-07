package BOJ.BOJ1103;

import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean infinite = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        int result = dfs(0, 0);

        if (infinite) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static int dfs(int x, int y) {

        if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 'H') {
            return 0;
        }

        if (visited[x][y]) {
            infinite = true;
            return 0;
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        visited[x][y] = true;

        int move = map[x][y] - '0';
        int max = 0;

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i] * move;
            int ny = y + dy[i] * move;

            max = Math.max(max, dfs(nx, ny) + 1);
        }

        visited[x][y] = false;

        dp[x][y] = max;

        return max;
    }
}