package BOJ.BOJ1941;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static char[][] board = new char[5][5];
    static boolean[] selected = new boolean[25];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String input = sc.next();
            for (int j = 0; j < 5; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        comb(0, 0, 0);

        System.out.println(result);
    }

    static void comb(int idx, int depth, int sCount) {
        if (depth - sCount >= 4) {
            return;
        }

        if (depth == 7) {
            if (sCount >= 4 && isConnected()) {
                result++;
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            selected[i] = true;
            if (board[i / 5][i % 5] == 'S') {
                comb(i + 1, depth + 1, sCount + 1);
            } else {
                comb(i + 1, depth + 1, sCount);
            }
            selected[i] = false;
        }
    }

    static boolean isConnected() {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[25];

        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                q.offer(i);
                visited[i] = true;
                break;
            }
        }

        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur / 5 + dx[d];
                int ny = cur % 5 + dy[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }

                int next = nx * 5 + ny;
                if (!selected[next] || visited[next]) {
                    continue;
                }

                visited[next] = true;
                q.offer(next);
                count++;
            }
        }

        return count == 7;
    }
}