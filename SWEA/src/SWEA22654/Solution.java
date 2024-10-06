package SWEA22654;

import java.util.Scanner;

public class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            char[][] input = new char[N][];

            for (int i = 0; i < input.length; i++) {
                input[i] = sc.next().toCharArray();
            }

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (input[i][j] == 'X') {
                        int Q = sc.nextInt();

                        int[] result = new int[Q];

                        for (int p = 0; p < Q; p++) {
                            int comCnt = sc.nextInt();

                            String command = sc.next();

                            int r = i;
                            int c = j;
                            int dir = 0;

                            for (int q = 0; q < comCnt; q++) {
                                switch (command.charAt(q)) {
                                    case 'A':
                                        int nr = r + dr[dir];
                                        int nc = c + dc[dir];

                                        if (nr < 0 || nc < 0 || nr >= input.length || nc >= input[0].length) {
                                            continue;
                                        }

                                        if (input[nr][nc] == 'T') {
                                            continue;
                                        }

                                        r = nr;
                                        c = nc;
                                        break;
                                    case 'L':
                                        dir -= 1;
                                        if (dir < 0) {
                                            dir += 4;
                                        }
                                        break;
                                    default:
                                        dir += 1;
                                        if (dir > 3) {
                                            dir -= 4;
                                        }
                                }
                            }

                            if (input[r][c] == 'Y') {
                                result[p] = 1;
                            }
                        }

                        StringBuilder sb = new StringBuilder();
                        sb.append("#").append(tc).append(" ");
                        for (int p = 0; p < Q; p++) {
                            sb.append(result[p]);

                            if (p != Q - 1) {
                                sb.append(" ");
                            }
                        }

                        System.out.println(sb);
                    }
                }
            }
        }
    }
}
