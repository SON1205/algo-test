package BOJ.BOJ14497;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] start = {sc.nextInt() - 1, sc.nextInt() - 1};
        int[] end = {sc.nextInt() - 1, sc.nextInt() - 1};
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '0' || input.charAt(j) == '*') {
                    map[i][j] = true;
                }
            }
        }

        int result = 0;
        while (true) {
            if (map[end[0]][end[1]]) {
                System.out.println(result);
                break;
            }

            result++;
            bfs(map, start);
        }
    }

    private static void bfs(boolean[][] map, int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (!map[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = true;
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
