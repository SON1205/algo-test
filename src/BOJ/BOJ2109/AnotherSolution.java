package BOJ.BOJ2109;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();

            arr[i][0] = d;
            arr[i][1] = p;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int until = arr[i][0];
            int val = arr[i][1];

            if (pq.size() < until) {
                pq.offer(val);
            } else if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        }

        int sum = 0;
        for (int i : pq) {
            sum += i;
        }

        System.out.println(sum);
    }
}
