package BOJ.BOJ2636;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> delList;
    static List<Integer> cheeseCountList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int originalCheeseCount = 0;
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sc.nextInt() == 1) {
                    map[i][j] = true;
                    originalCheeseCount++;
                }
            }
        }

        while (true) {
            visited = new boolean[N][M];
            delList = new ArrayList<>();
            bfs(map, 0, 0);

            int cheeseCount = countCheese(map);
            cheeseCountList.add(cheeseCount);

            if (cheeseCount == 0) {
                System.out.println(cheeseCountList.size());
                if (cheeseCountList.size() == 1) {
                    System.out.println(originalCheeseCount);
                    return;
                }
                System.out.println(cheeseCountList.get(cheeseCountList.size() - 2));

                return;
            }
        }
    }

    private static void bfs(boolean[][] map, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny]) {
                    delList.add(new int[]{nx, ny});
                } else {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int[] xy : delList) {
            map[xy[0]][xy[1]] = false;
        }
    }

    private static int countCheese(boolean[][] map) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
