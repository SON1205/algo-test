package BOJ.BOJ1726;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0}; // 북(4), 동(1), 남(3), 서(2)
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt() == 1 ? -1 : 0;
            }
        }

        int[] start = setUV(sc);
        int[] end = setUV(sc);

        System.out.println(bfs(map, start, end));
    }

    private static int[] setUV(Scanner sc) {
        int[] tmp = new int[3];
        for (int i = 0; i < 2; i++) {
            tmp[i] = sc.nextInt() - 1;
        }

        int dir = sc.nextInt();
        switch (dir) {
            case 1:
                tmp[2] = 1;
                break;
            case 2:
                tmp[2] = 3;
                break;
            case 3:
                tmp[2] = 2;
                break;
            case 4:
                tmp[2] = 0;
                break;
        }
        return tmp;
    }

    private static int bfs(int[][] map, int[] start, int[] end) {
        int N = map.length;
        int M = map[0].length;

        boolean[][][] visited = new boolean[N][M][4];
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2], cnt = cur[3];

            if (x == end[0] && y == end[1] && dir == end[2]) {
                return cnt;
            }

            // 회전
            int left = (dir + 3) % 4;
            int right = (dir + 1) % 4;

            if (!visited[x][y][left]) {
                visited[x][y][left] = true;
                q.offer(new int[]{x, y, left, cnt + 1});
            }

            if (!visited[x][y][right]) {
                visited[x][y][right] = true;
                q.offer(new int[]{x, y, right, cnt + 1});
            }

            // 이동
            for (int k = 1; k <= 3; k++) {
                int nx = x + dx[dir] * k;
                int ny = y + dy[dir] * k;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    break;
                }
                if (map[nx][ny] == -1) {
                    break;
                }

                if (!visited[nx][ny][dir]) {
                    visited[nx][ny][dir] = true;
                    q.offer(new int[]{nx, ny, dir, cnt + 1});
                }
            }
        }
        return -1;
    }

}
