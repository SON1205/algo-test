package BOJ.BOJ21608;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] scores = {0, 1, 10, 100, 1000};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        List<List<Integer>> surveys = new ArrayList<>();
        for (int i = 0; i < N * N + 1; i++) {
            surveys.add(new ArrayList<>());
        }

        for (int i = 1; i <= N * N; i++) {
            int student = sc.nextInt();
            List<Integer> survey = surveys.get(student);
            for (int j = 0; j < 4; j++) {
                survey.add(sc.nextInt());
            }

            List<int[]> substitutes = new ArrayList<>();
            for (int p = 0; p < map.length; p++) {
                for (int q = 0; q < map[p].length; q++) {
                    if (map[p][q] != 0) {
                        continue;
                    }

                    int[] tmp = new int[4];
                    tmp[0] = p;
                    tmp[1] = q;
                    for (int k = 0; k < 4; k++) {
                        int nx = p + dx[k];
                        int ny = q + dy[k];

                        if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                            continue;
                        }

                        if (survey.contains(map[nx][ny])) {
                            tmp[2]++;
                        }

                        if (map[nx][ny] == 0) {
                            tmp[3]++;
                        }
                    }

                    substitutes.add(tmp);
                }
            }

            substitutes.sort(
                    (a, b) -> {
                        if (a[2] != b[2]) {
                            return b[2] - a[2];
                        }
                        if (a[3] != b[3]) {
                            return b[3] - a[3];
                        }
                        if (a[0] != b[0]) {
                            return a[0] - b[0];
                        }
                        return a[1] - b[1];
                    });

            int[] pos = substitutes.get(0);
            map[pos[0]][pos[1]] = student;
        }

        System.out.println(checkFavorite(map, surveys));
    }

    private static int checkFavorite(int[][] map, List<List<Integer>> surveys) {
        int total = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int student = map[i][j];
                List<Integer> survey = surveys.get(student);
                int cnt = 0;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                        continue;
                    }

                    if (survey.contains(map[nx][ny])) {
                        cnt++;
                    }
                }

                total += scores[cnt];
            }
        }

        return total;
    }
}
