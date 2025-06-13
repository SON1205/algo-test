package BOJ.BOJ16234;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int sum = dfs(i, j, union);
                        if (union.size() > 1) {
                            moved = true;
                            int avg = sum / union.size();
                            for (int[] pos : union) {
                                A[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            result++;
        }

        System.out.println(result);
    }

    static int dfs(int x, int y, List<int[]> union) {
        visited[x][y] = true;
        union.add(new int[]{x, y});
        int sum = A[x][y];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (!visited[nx][ny]) {
                int diff = Math.abs(A[x][y] - A[nx][ny]);

                if (L <= diff && diff <= R) {
                    sum += dfs(nx, ny, union);
                }
            }
        }

        return sum;
    }
}
