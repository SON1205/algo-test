package BOJ2583;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int tmp;
    static List<Integer> results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int startC = sc.nextInt();
            int startR = M - 1 - sc.nextInt();
            int endC = sc.nextInt();
            int endR = M - 1 - sc.nextInt();

            for (int j = startR; j > endR; j--) {
                for (int k = startC; k < endC; k++) {
                    visited[j][k] = true;
                }
            }
        }

        results = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
//                    System.out.println("i= " + i + ", j= " + j);
                    tmp = 1;
                    dfs(visited, i, j, 1);
                    results.add(tmp);
                }
            }
        }

        Collections.sort(results);

        System.out.println(results.size());
        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }

    static void dfs(boolean[][] visited, int r, int c, int cnt) {
        visited[r][c] = true;

        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= visited.length || nc >= visited[0].length) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

//            System.out.println("nr= " + nr + ", nc=" + nc);
            dfs(visited, nr, nc, tmp++);
        }
    }
}
