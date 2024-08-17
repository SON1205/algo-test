package BOJ2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = sc.next().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        house = new boolean[N][N];
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !house[i][j]) {
                    cnt = 0;
                    countingHouse(map, i, j);
                    output.add(cnt);
                }
            }
        }

        Collections.sort(output);

        System.out.println(output.size());

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] house;
    static int cnt;

    static void countingHouse(int[][] map, int x, int y) {
        house[x][y] = true;
        cnt++;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) {
                continue;
            }

            if (map[nx][ny] == 0 || house[nx][ny]) {
                continue;
            }

            if (map[nx][ny] == 1 && !house[nx][ny]) {
                house[nx][ny] = true;
                countingHouse(map, nx, ny);
            }
        }
    }
}
