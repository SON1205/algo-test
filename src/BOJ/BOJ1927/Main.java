package BOJ.BOJ1927;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int next = sc.nextInt();

            if (next != 0) {
                pq.offer(next);
                continue;
            }

            if (pq.isEmpty()) {
                sb.append(0).append("\n");
                continue;
            }

            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
