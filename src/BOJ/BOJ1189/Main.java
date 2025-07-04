package BOJ.BOJ1189;

import java.util.Scanner;

public class Main {
    static boolean[][] map;
    static int result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();
        map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'T') {
                    map[i][j] = true;
                }
            }
        }

        visited = new boolean[R][C];

        visited[R - 1][0] = true;
        dfs(R - 1, 0, K, 1);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int k, int tmp) {
        if (tmp == k) {
            if (x == 0 && y == map[0].length - 1) {
                result++;
            }
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }

            if (map[nx][ny] || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, k, tmp + 1);
            visited[nx][ny] = false;
        }
    }
}
