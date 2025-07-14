package BOJ.BOJ14890;

import java.util.Scanner;

public class Main {
    static int N, L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isValid(map[i])) {
                count++;                // 가로
            }
            if (isValid(getColumn(map, i))) {
                count++;      // 세로
            }
        }

        System.out.println(count);
    }

    static boolean isValid(int[] line) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = line[i + 1] - line[i];

            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) > 1) {
                return false;
            }

            if (diff == 1) { // 오르막
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || line[j] != line[i] || used[j]) {
                        return false;
                    }
                    used[j] = true;
                }
            }

            if (diff == -1) { // 내리막
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || line[j] != line[i + 1] || used[j]) {
                        return false;
                    }
                    used[j] = true;
                }
            }
        }

        return true;
    }

    static int[] getColumn(int[][] map, int col) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = map[i][col];
        }
        return result;
    }
}
