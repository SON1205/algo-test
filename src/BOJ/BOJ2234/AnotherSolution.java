package BOJ.BOJ2234;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnotherSolution {
    static int N, M;
    static int[][] map;         // 성곽 지도
    static int[][] roomIdMap;   // 방 번호 표시
    static int[] dx = {0, -1, 0, 1}; // 서, 북, 동, 남
    static int[] dy = {-1, 0, 1, 0};
    static Map<Integer, Integer> roomAreaMap = new HashMap<>();
    static int roomId = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 열 수
        M = sc.nextInt(); // 행 수
        map = new int[M][N];
        roomIdMap = new int[M][N];

        // 입력 받기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int maxArea = 0;

        // 1. DFS로 방 구분 및 넓이 계산
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (roomIdMap[i][j] == 0) {
                    int area = dfs(i, j, roomId);
                    roomAreaMap.put(roomId, area);
                    maxArea = Math.max(maxArea, area);
                    roomId++;
                }
            }
        }

        // 2. 벽 하나를 제거했을 때 최대 방 크기 계산
        int maxCombined = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int currentRoom = roomIdMap[i][j];
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (ni < 0 || nj < 0 || ni >= M || nj >= N) {
                        continue;
                    }

                    int nextRoom = roomIdMap[ni][nj];
                    if (currentRoom != nextRoom) {
                        int combined = roomAreaMap.get(currentRoom) + roomAreaMap.get(nextRoom);
                        maxCombined = Math.max(maxCombined, combined);
                    }
                }
            }
        }

        // 출력
        System.out.println(roomId - 1);  // 1. 방 개수
        System.out.println(maxArea);     // 2. 가장 큰 방 넓이
        System.out.println(maxCombined); // 3. 벽 제거 후 최대 넓이
    }

    // DFS로 방 번호 부여 및 넓이 계산
    private static int dfs(int x, int y, int id) {
        roomIdMap[x][y] = id;
        int area = 1;

        for (int d = 0; d < 4; d++) {
            if ((map[x][y] & (1 << d)) != 0) {
                continue; // 벽 있음
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }
            if (roomIdMap[nx][ny] != 0) {
                continue;
            }

            area += dfs(nx, ny, id);
        }

        return area;
    }
}
