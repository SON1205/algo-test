package BOJ.BOJ2146;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static int[][] owner;   // 어느 섬에서 왔는지
    static int[][] dist;    // 바다 확장 거리
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 1️⃣ 섬 라벨링
        int islandId = 2;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j, islandId++, visited);
                }
            }
        }

        // 2️⃣ 멀티 소스 BFS 준비
        owner = new int[N][N];
        dist = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) { // 섬
                    owner[i][j] = map[i][j];
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        // 3️⃣ 멀티 소스 BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                // 아직 방문 안 한 바다
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    owner[nx][ny] = owner[x][y];
                    q.offer(new int[]{nx, ny});
                }
                // 다른 섬에서 이미 확장해온 칸
                else if (owner[nx][ny] != owner[x][y]) {
                    answer = Math.min(answer, dist[nx][ny] + dist[x][y]);
                }
            }
        }

        System.out.println(answer);
    }

    // 섬 하나를 라벨링
    static void labelIsland(int x, int y, int id, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] != 1) {
                    continue;
                }

                visited[nx][ny] = true;
                map[nx][ny] = id;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
