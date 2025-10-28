package BOJ.BOJ3190;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            map[sc.nextInt() - 1][sc.nextInt() - 1] = true;
        }

        int L = sc.nextInt();
        Map<Integer, Integer> turn = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int t = sc.nextInt();
            int d = sc.next().equals("L") ? 1 : -1;
            turn.put(t, d);
        }

        int result = 0;
        int dir = 3;
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});

        while (true) {
            result++;

            int[] now = snake.getFirst();

            int nx = now[0] + dx[dir];
            int ny = now[1] + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                break;
            }

            for (int[] b : snake) {
                if (b[0] == nx && b[1] == ny) {
                    System.out.println(result);
                    return;
                }
            }

            snake.addFirst(new int[]{nx, ny});
            if (!map[nx][ny]) {
                snake.removeLast();
            } else {
                map[nx][ny] = false;
            }

            if (turn.containsKey(result)) {
                dir = (dir + turn.get(result) + dx.length) % dx.length;
            }
        }

        System.out.println(result);
    }
}
