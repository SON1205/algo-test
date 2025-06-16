package BOJ.BOJ15686;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int result = Integer.MAX_VALUE;
    static List<int[]> houses;
    static List<int[]> chickens;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = sc.nextInt();

                if (input == 1) {
                    houses.add(new int[]{i, j});
                } else if (input == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chickens.size()];
        combi(M, 0, 0);

        System.out.println(result);
    }

    static void combi(int M, int start, int depth) {
        if (depth == M) {
            int curResult = 0;

            for (int h = 0; h < houses.size(); h++) {
                int minDist = Integer.MAX_VALUE;

                for (int c = 0; c < chickens.size(); c++) {
                    if (!visited[c]) {
                        continue;
                    }

                    int dist = Math.abs(houses.get(h)[0] - chickens.get(c)[0])
                            + Math.abs(houses.get(h)[1] - chickens.get(c)[1]);

                    minDist = Math.min(minDist, dist);
                }

                curResult += minDist;
            }

            result = Math.min(result, curResult);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            combi(M, i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
