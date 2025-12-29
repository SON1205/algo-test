package BOJ.BOJ2206;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) == '0';
            }
        }

        bfs(map, new int[N][M][2]);
    }

    private static void bfs(boolean[][] map, int[][][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == map.length - 1 && cur[1] == map[0].length - 1) {
                System.out.println(visited[cur[0]][cur[1]][cur[2]]);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (!map[nx][ny] && cur[2] == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = visited[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{nx, ny, 1});
                }

                if (map[nx][ny] && visited[nx][ny][cur[2]] == 0) {
                    visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{nx, ny, cur[2]});
                }
            }
        }

        System.out.println(-1);
    }
}
