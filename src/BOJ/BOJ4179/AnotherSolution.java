package BOJ.BOJ4179;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AnotherSolution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        Deque<Node> q = new ArrayDeque<>();

        int startX = -1, startY = -1;

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'F') {
                    q.offer(new Node(i, j, 0, true)); // 불 먼저 큐에 넣음
                }
            }
        }

        q.offer(new Node(startX, startY, 0, false));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    if (!cur.isFire) {
                        System.out.println(cur.time + 1);
                        return;
                    }
                    continue;
                }

                if (cur.isFire) {
                    if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
                        map[nx][ny] = 'F';
                        q.offer(new Node(nx, ny, cur.time + 1, true));
                    }
                } else {
                    if (!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, cur.time + 1, false));
                    }
                }
            }
        }

        System.out.println(IMPOSSIBLE);
    }

    static class Node {
        int x, y, time;
        boolean isFire;

        public Node(int x, int y, int time, boolean isFire) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isFire = isFire;
        }
    }
}
