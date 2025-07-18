package BOJ.BOJ14391;

import java.util.Scanner;

public class Main {
    static int maxSum = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < (1 << (N * M)); i++) {
            maxSum = Math.max(maxSum, calculate(map, i, N, M));
        }

        System.out.println(maxSum);
    }

    private static int calculate(int[][] map, int num, int N, int M) {
        int total = 0;

        // 가로 조각
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < M; j++) {
                int idx = i * M + j;
                if ((num & (1 << idx)) != 0) {  // 가로 조각
                    tmp = 10 * tmp + map[i][j];
                } else {
                    total += tmp;
                    tmp = 0;
                }
            }
            total += tmp;
        }

        // 세로 조각
        for (int i = 0; i < M; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                int idx = j * M + i;
                if ((num & (1 << idx)) == 0) {  // 세로 조각
                    tmp = 10 * tmp + map[j][i];
                } else {
                    total += tmp;
                    tmp = 0;
                }
            }
            total += tmp;
        }

        return total;
    }
}
