package BOJ.BOJ2589;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AnotherSolution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static int visitMarker = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        boolean[][] map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) == 'L';
            }
        }

        visited = new int[R][C];
        int result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j]) {
                    result = Math.max(result, bfs(map, i, j));
                    visitMarker++;
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(boolean[][] map, int x, int y) {
        int maxDist = 0;
        int R = map.length, C = map[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = visitMarker;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            maxDist = curr[2];

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d], ny = curr[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (!map[nx][ny] || visited[nx][ny] == visitMarker) {
                    continue;
                }
                visited[nx][ny] = visitMarker;
                q.offer(new int[]{nx, ny, curr[2] + 1});
            }
        }
        return maxDist;
    }
}
