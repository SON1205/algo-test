package BOJ.BOJ18870;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < N; i++) {
            pq.offer(new int[]{i, sc.nextInt()});
        }

        int idx = -1;
        int prev = -1_000_000_001;
        int[] answer = new int[N];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (prev == cur[1]) {
                answer[cur[0]] = idx;
            } else {
                answer[cur[0]] = ++idx;
            }

            prev = cur[1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
