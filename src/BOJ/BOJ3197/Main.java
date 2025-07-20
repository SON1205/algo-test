package BOJ.BOJ3197;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<int[]> swans = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] swanVisited;
    static Deque<int[]> swanQ = new ArrayDeque<>();
    static int[] end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        boolean[][] map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'L' || input.charAt(j) == '.') {
                    map[i][j] = true;

                    if (input.charAt(j) == 'L') {
                        swans.add(new int[]{i, j});
                    }
                }
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[map.length][map[0].length];
        swanVisited = new boolean[map.length][map[0].length];
        int[] start = swans.get(0);
        end = swans.get(1);
        swanQ.offer(start);
        swanVisited[start[0]][start[1]] = true;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j]) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int cnt = 0;
        while (!check(map)) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int p = 0; p < dx.length; p++) {
                    int nx = curr[0] + dx[p];
                    int ny = curr[1] + dy[p];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }

                    if (map[nx][ny] || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    map[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean check(boolean[][] map) {
        Deque<int[]> next = new ArrayDeque<>();
        while (!swanQ.isEmpty()) {
            int[] curr = swanQ.poll();

            if (curr[0] == end[0] && curr[1] == end[1]) {
                return true;
            }

            for (int p = 0; p < dx.length; p++) {
                int nx = curr[0] + dx[p];
                int ny = curr[1] + dy[p];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (swanVisited[nx][ny]) {
                    continue;
                }

                swanVisited[nx][ny] = true;

                if (map[nx][ny]) {
                    swanQ.offer(new int[]{nx, ny});
                } else {
                    next.offer(new int[]{nx, ny});
                }
            }
        }

        swanQ = next;
        return false;
    }
}
