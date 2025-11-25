package BOJ.BOJ4485;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;

        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int[][] dis = dji(map, 0, 0);

            System.out.printf("Problem %d: %d\n", t++, dis[N - 1][N - 1]);
        }
    }

    public static int[][] dji(int[][] map, int x, int y) {
        int[][] result = new int[map.length][map[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        result[x][y] = map[x][y];
        q.offer(new int[]{x, y, map[x][y]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] < 0) {
                    continue;
                }

                if (result[nx][ny] > result[cur[0]][cur[1]] + map[nx][ny]) {
                    result[nx][ny] = result[cur[0]][cur[1]] + map[nx][ny];
                    q.offer(new int[]{nx, ny, result[nx][ny]});
                }
            }
        }

        return result;
    }
}
