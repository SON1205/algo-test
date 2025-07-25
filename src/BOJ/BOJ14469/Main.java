package BOJ.BOJ14469;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            pq.offer(new int[]{sc.nextInt(), sc.nextInt()});
        }

        int end = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (end >= cur[0]) {
                end += cur[1];
            } else {
                end = cur[0] + cur[1];
            }
        }

        System.out.println(end);
    }
}
