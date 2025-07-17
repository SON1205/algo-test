package BOJ.BOJ2234;

import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int maxArea = -1;
    static int count = 0;
    static int mergeMaxCnt = -1;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    int area = dfs(map, i, j);
                    count++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 2; k <= 3; k++) {
                    if ((map[i][j] & (1 << k)) != 0) {
                        int original = map[i][j];
                        map[i][j] = map[i][j] - (1 << k);
                        visited = new boolean[M][N];
                        visited[i][j] = true;
                        int area = dfs(map, i, j);
                        mergeMaxCnt = Math.max(mergeMaxCnt, area);
                        map[i][j] = original;
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((map[i][j] & (1 << k)) == 0) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            int area = dfs(map, nx, ny);
                            mergeMaxCnt = Math.max(mergeMaxCnt, area);
                            visited[nx][ny] = false;
                        }
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
        System.out.println(mergeMaxCnt);
    }

    private static int dfs(int[][] map, int x, int y) {
        int cnt = 1;

        for (int i = 0; i < dx.length; i++) {
            if ((map[x][y] & (1 << i)) != 0) {
                continue;
            }

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                cnt += dfs(map, nx, ny);
            }
        }

        return cnt;
    }
}
