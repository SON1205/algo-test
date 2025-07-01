package BOJ.BOJ17071;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static final int MAX = 500_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        // visited[0][x]: 짝수 시간에 x 위치 방문, visited[1][x]: 홀수 시간에 x 위치 방문
        boolean[][] visited = new boolean[2][MAX + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);
        visited[0][N] = true;

        int time = 0;
        while (true) {
            int target = K + time * (time + 1) / 2;
            if (target > MAX) {
                return -1;
            }
            if (visited[time % 2][target]) {
                return time;
            }

            int size = deque.size();
            if (size == 0) {
                return -1; // 탐색할 곳이 더이상 없음
            }

            for (int i = 0; i < size; i++) {
                int curr = deque.poll();
                for (int next : new int[]{curr - 1, curr + 1, curr * 2}) {
                    if (next < 0 || next > MAX) {
                        continue;
                    }
                    if (!visited[(time + 1) % 2][next]) {
                        visited[(time + 1) % 2][next] = true;
                        deque.offer(next);
                    }
                }
            }
            time++;
        }
    }
}
