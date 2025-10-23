package BOJ.BOJ17822;

import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        int[][] boards = new int[N + 1][M];
        for (int i = 1; i <= N; i++) {
            int[] board = boards[i];
            for (int j = 0; j < M; j++) {
                board[j] = sc.nextInt();
            }
        }

        while (T-- > 0) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();

            rotateBoards(boards, x, d, k);
            go(boards);
        }

        System.out.println(sum(boards));
    }

    private static void rotateBoards(int[][] boards, int x, int d, int k) {
        int N = boards.length - 1;
        int M = boards[1].length;

        k = k % M;
        if (k == 0) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i % x != 0) {
                continue;
            }

            int[] board = boards[i];
            int[] tmp = new int[M];

            if (d == 0) {
                for (int j = 0; j < M; j++) {
                    tmp[(j + k) % M] = board[j];
                }
            } else {
                for (int j = 0; j < M; j++) {
                    tmp[(j - k + M) % M] = board[j];
                }
            }

            boards[i] = tmp;
        }
    }

    private static int sum(int[][] boards) {
        int total = 0;
        for (int i = 1; i < boards.length; i++) {
            for (int v : boards[i]) {
                total += v;
            }
        }
        return total;
    }

    private static void go(int[][] boards) {
        int N = boards.length - 1;
        int M = boards[1].length;

        boolean[][] remove = new boolean[N + 1][M];
        boolean anyRemoved = false;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (boards[i][j] == 0) {
                    continue;
                }

                int val = boards[i][j];
                for (int q = 0; q < 4; q++) {
                    int nx = i + dx[q];
                    int ny = j + dy[q];

                    if (nx <= 0 || nx > N) {
                        continue;
                    }
                    if (ny < 0) {
                        ny = M - 1;
                    } else if (ny >= M) {
                        ny = 0;
                    }

                    if (boards[nx][ny] == val) {
                        remove[i][j] = true;
                        remove[nx][ny] = true;
                        anyRemoved = true;
                    }
                }
            }
        }

        if (anyRemoved) {
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (remove[i][j]) {
                        boards[i][j] = 0;
                    }
                }
            }
        } else {
            int total = 0;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (boards[i][j] != 0) {
                        total += boards[i][j];
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                return;
            }

            double avg = (double) total / cnt;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if (boards[i][j] == 0) {
                        continue;
                    }

                    if (boards[i][j] > avg) {
                        boards[i][j]--;
                    } else if (boards[i][j] < avg) {
                        boards[i][j]++;
                    }
                }
            }
        }
    }
}
