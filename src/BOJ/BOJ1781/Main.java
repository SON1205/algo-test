package BOJ.BOJ1781;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        list.sort((a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] ints : list) {
            pq.offer(ints[1]);

            if (pq.size() > ints[0]) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}
