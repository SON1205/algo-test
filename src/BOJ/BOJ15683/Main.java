package BOJ.BOJ15683;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> cctvList = new ArrayList<>();
    static int minBlind = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0}; // 위, 오른, 아래, 왼
    static int[] dy = {0, 1, 0, -1};

    // CCTV별 방향 조합
    static int[][][] directions = {
            {}, // index 0은 사용 안 함
            {{0}, {1}, {2}, {3}},              // 1번
            {{0, 2}, {1, 3}},                  // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},  // 3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
            {{0, 1, 2, 3}}                     // 5번
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        dfs(0, map);
        System.out.println(minBlind);
    }

    private static void dfs(int idx, int[][] prevMap) {
        if (idx == cctvList.size()) {
            minBlind = Math.min(minBlind, countBlind(prevMap));
            return;
        }

        int[] cctv = cctvList.get(idx);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        for (int[] dirs : directions[type]) {
            int[][] copyMap = copy(prevMap);
            for (int d : dirs) {
                watch(copyMap, x, y, d);
            }
            dfs(idx + 1, copyMap);
        }
    }

    private static void watch(int[][] map, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 6) {
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1; // 감시됨 표시
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    private static int[][] copy(int[][] src) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = src[i].clone();
        }
        return newMap;
    }

    private static int countBlind(int[][] map) {
        int cnt = 0;
        for (int[] row : map) {
            for (int v : row) {
                if (v == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
