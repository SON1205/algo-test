package BOJ.BOJ14497;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AnotherSolution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] start = {sc.nextInt() - 1, sc.nextInt() - 1};
        int[] end = {sc.nextInt() - 1, sc.nextInt() - 1};
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '0' || input.charAt(j) == '*') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        System.out.println(bfs(map, start, end));
    }

    private static int bfs(int[][] map, int[] start, int[] end) {
        int N = map.length;
        int M = map[0].length;
        boolean[][] visited;
        Deque<int[]> current = new ArrayDeque<>();
        current.add(start);
        int steps = 0;

        while (true) {
            Deque<int[]> next = new ArrayDeque<>();
            visited = new boolean[N][M];

            while (!current.isEmpty()) {
                int[] pos = current.poll();
                int x = pos[0], y = pos[1];

                if (x == end[0] && y == end[1]) {
                    return steps;
                }
                visited[x][y] = true;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        current.add(new int[]{nx, ny});
                    } else if (map[nx][ny] == 1) {
                        next.add(new int[]{nx, ny});
                        // 칼로 부순다 (다음 단계에 이동 가능)
                        map[nx][ny] = 0;
                    }
                }
            }

            current = next;
            steps++;
        }
    }
}
