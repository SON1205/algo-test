package BOJ.BOJ2589;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = -1;
        int R = sc.nextInt();
        int C = sc.nextInt();
        boolean[][] map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'L') {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j]) {
                    result = Math.max(result, bfs(map, new boolean[R][C], i, j));
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(boolean[][] map, boolean[][] visited, int x, int y) {
        int result = -1;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int[] next = {curr[0] + dx[i], curr[1] + dy[i], curr[2] + 1};

                if (next[0] < 0 || next[1] < 0 || next[0] >= map.length || next[1] >= map[0].length) {
                    continue;
                }

                if (!map[next[0]][next[1]] || visited[next[0]][next[1]]) {
                    continue;
                }

                visited[next[0]][next[1]] = true;
                result = Math.max(result, next[2]);
                q.offer(next);
            }
        }

        return result;
    }
}
