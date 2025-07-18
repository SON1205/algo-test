package BOJ.BOJ14620;

import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N][N];
        dfs(map, 0, 0, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int[][] map, int x, int y, int count, int sum) {
        if (count == 3) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = x; i < map.length; i++) {
            for (int j = (i == x ? y : 0); j < map[i].length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                boolean canPlant = true;
                int cost = map[i][j];

                for (int d = 0; d < dx.length; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[i].length || visited[nx][ny]) {
                        canPlant = false;
                        break;
                    }
                    cost += map[nx][ny];
                }

                if (canPlant) {
                    visited[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        visited[nx][ny] = true;
                    }
                    dfs(map, i, j, count + 1, sum + cost);
                    visited[i][j] = false;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
}
