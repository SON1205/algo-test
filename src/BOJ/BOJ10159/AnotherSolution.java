package BOJ.BOJ10159;

import java.util.Scanner;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] dist = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dist[a][b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int known = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                if (dist[i][j] || dist[j][i]) {
                    known++;
                }
            }

            sb.append(N - 1 - known).append("\n");
        }

        System.out.print(sb);
    }
}
