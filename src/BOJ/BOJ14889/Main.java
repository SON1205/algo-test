package BOJ.BOJ14889;

import java.util.Scanner;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        combi(0, 0, new boolean[N]);
        System.out.println(result);
    }

    private static void combi(int start, int cnt, boolean[] visited) {
        if (cnt == visited.length / 2) {
            result = Math.min(result, calculate(visited));
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            combi(i, cnt + 1, visited);
            visited[i] = false;
        }
    }

    private static int calculate(boolean[] visited) {
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 0; i < visited.length - 1; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    tmp1 += map[i][j];
                    tmp1 += map[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    tmp2 += map[i][j];
                    tmp2 += map[j][i];
                }
            }
        }
        return Math.abs(tmp1 - tmp2);
    }
}
