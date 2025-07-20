package BOJ.BOJ3197;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class RefactorMain {
    static List<int[]> swans = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> go = new ArrayDeque<>();
    static boolean[][] visitedBySwan;
    static Deque<int[]> melting = new ArrayDeque<>();
    static boolean[][] visitedMelting;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        boolean[][] map = new boolean[R][C];
        visitedBySwan = new boolean[R][C];
        visitedMelting = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'L') {
                    map[i][j] = true;
                    swans.add(new int[]{i, j});
                    visitedMelting[i][j] = true;
                    melting.offer(new int[]{i, j});
                    continue;
                }

                if (input.charAt(j) == '.') {
                    map[i][j] = true;
                    visitedMelting[i][j] = true;
                    melting.offer(new int[]{i, j});
                }
            }
        }

        int cnt = 0;
        int[] start = swans.get(0);
        go.offer(start);
        visitedBySwan[start[0]][start[1]] = true;
        while (!go(map)) {
            meltingIce(map);
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void meltingIce(boolean[][] map) {
        int size = melting.size();
        for (int i = 0; i < size; i++) {
            int[] cur = melting.poll();

            for (int j = 0; j < dx.length; j++) {
                int nx = cur[0] + dx[j];
                int ny = cur[1] + dy[j];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }

                if (visitedMelting[nx][ny] || map[nx][ny]) {
                    continue;
                }

                visitedMelting[nx][ny] = true;
                map[nx][ny] = true;
                melting.offer(new int[]{nx, ny});
            }
        }
    }

    private static boolean go(boolean[][] map) {
        Deque<int[]> nextGo = new ArrayDeque<>();
        while (!go.isEmpty()) {
            int[] cur = go.poll();

            if (cur[0] == swans.get(1)[0] && cur[1] == swans.get(1)[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (visitedBySwan[nx][ny]) {
                    continue;
                }

                visitedBySwan[nx][ny] = true;
                if (map[nx][ny]) {
                    go.offer(new int[]{nx, ny});
                } else {
                    nextGo.offer(new int[]{nx, ny});
                }
            }
        }

        go = nextGo;
        return false;
    }
}
