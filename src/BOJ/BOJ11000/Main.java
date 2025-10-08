package BOJ.BOJ11000;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]> lecs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lecs.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        lecs.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lecs.get(0)[1]);

        for (int i = 1; i < N; i++) {
            if (lecs.get(i)[0] >= pq.peek()) {
                pq.poll();
            }

            pq.add(lecs.get(i)[1]);
        }

        System.out.println(pq.size());
    }
}
