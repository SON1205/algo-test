package BOJ.BOJ4179;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        Deque<int[]> queue = new ArrayDeque<>();
        Deque<int[]> fires = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        int result = 0;

        boolean[][] map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();

            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == '.' || input.charAt(j) == 'J') {
                    map[i][j] = true;

                    if (input.charAt(j) == 'J') {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }

                if (input.charAt(j) == 'F') {
                    fires.offer(new int[]{i, j});
                }
            }
        }

        while (true) {
            fires = moveFire(map, fires);

            Deque<int[]> tmpQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                if (tmp[0] == 0 || tmp[1] == 0 || tmp[0] == R - 1 || tmp[1] == C - 1) {
                    System.out.println(result + 1);
                    return;
                }

                for (int i = 0; i < dx.length; i++) {
                    int[] nTmp = {tmp[0] + dx[i], tmp[1] + dy[i]};

                    if (nTmp[0] < 0 || nTmp[0] >= map.length || nTmp[1] < 0 || nTmp[1] >= map[0].length) {
                        continue;
                    }

                    if (!map[nTmp[0]][nTmp[1]] || visited[nTmp[0]][nTmp[1]]) {
                        continue;
                    }

                    tmpQueue.offer(nTmp);
                    visited[nTmp[0]][nTmp[1]] = true;
                }
            }

            if (tmpQueue.isEmpty()) {
                break;
            }

            queue = tmpQueue;

            result++;
        }

        System.out.println(IMPOSSIBLE);
    }

    private static Deque<int[]> moveFire(boolean[][] map, Deque<int[]> fires) {
        Deque<int[]> tmpQueue = new ArrayDeque<>();
        while (!fires.isEmpty()) {
            int[] tmp = fires.poll();
            for (int j = 0; j < dx.length; j++) {
                int[] nTmp = {tmp[0] + dx[j], tmp[1] + dy[j]};

                if (nTmp[0] < 0 || nTmp[0] >= map.length || nTmp[1] < 0 || nTmp[1] >= map[0].length) {
                    continue;
                }

                if (!map[nTmp[0]][nTmp[1]]) {
                    continue;
                }

                map[nTmp[0]][nTmp[1]] = false;
                tmpQueue.offer(nTmp);
            }
        }

        return tmpQueue;
    }
}
