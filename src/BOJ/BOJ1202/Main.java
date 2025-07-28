package BOJ.BOJ1202;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<int[]> jew = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            jew.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            bags.offer(sc.nextInt());
        }

        jew.sort(Comparator.comparingInt(a -> a[0]));

        long total = 0;
        int idx = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        while (!bags.isEmpty()) {
            int bag = bags.poll();
            while (idx < jew.size()) {
                if (bag < jew.get(idx)[0]) {
                    break;
                }

                q.offer(jew.get(idx)[1]);
                idx++;
            }

            if (!q.isEmpty()) {
                total += q.poll();
            }
        }

        System.out.println(total);
    }
}
