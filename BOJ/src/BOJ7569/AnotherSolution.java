package BOJ7569;

import java.io.*;
import java.util.*;

public class AnotherSolution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K, day = 0;
    static int[][][] adj;
    static boolean[][][] visited;
    static int[] dr = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dh = new int[]{0, 0, 0, 0, 1, -1};
    static ArrayDeque<int[]> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new int[N][M][K];

        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    adj[i][j][k] = num;
                    if (num == 1) Q.add(new int[]{i, j, k});
                }
            }
        }
        //////////////////////////////////////////////////////

        while (!Q.isEmpty()) {
            int[] ints = Q.removeFirst();
            int r = ints[0];
            int c = ints[1];
            int h = ints[2];

            for (int i = 0; i < 6; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nh = h + dh[i];

                if (nr >= 0 && nc >= 0 && nh >= 0 && nr < N && nc < M && nh < K && adj[nr][nc][nh] == 0) {
                    Q.add(new int[]{nr, nc, nh});
                    adj[nr][nc][nh] = adj[r][c][h] + 1;
                }
            }
        }

        //////////////////////////////////////////////////////



        for (int k = 0; k < K; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++) {
                    if (adj[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    day = Math.max(day, adj[i][j][k]);
                }
            }
        }
        System.out.print(day-1);
    }
}