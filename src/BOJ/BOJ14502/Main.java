package BOJ.BOJ14502;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int result = Integer.MIN_VALUE;
    static List<int[]> labs = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int[] selected = new int[3];
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 0) {
                    labs.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0);

        System.out.println(result);
    }

    static void comb(int start, int cnt) {
        if (cnt == 3) {
            Deque<int[]> q = new ArrayDeque<>();
            visited = new boolean[map.length][map[0].length];
            for (int[] virus : viruses) {
                q.offer(virus);
                visited[virus[0]][virus[1]] = true;
            }

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                for (int i = 0; i < dx.length; i++) {
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];

                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                        continue;
                    }

                    if (visited[nx][ny] || map[nx][ny] == 1) {
                        continue;
                    }

                    boolean flag = false;
                    for (int s : selected) {
                        if (nx == labs.get(s)[0] && ny == labs.get(s)[1]) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            int tmp = 0;
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[i].length; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        tmp++;
                    }
                }
            }

            result = Math.max(result, tmp - 3);
            return;
        }

        for (int i = start; i < labs.size(); i++) {
            selected[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }
}
