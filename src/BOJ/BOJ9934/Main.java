package BOJ.BOJ9934;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[] arr = new int[(1 << K)];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        bfs(arr, K);
    }

    private static void bfs(int[] arr, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int start = (1 << k - 1);
        q.offer(start);

        int cnt = k - 1;
        while (cnt >= 0) {
            int size = q.size();
            cnt--;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                sb.append(arr[cur]).append(" ");
                int left = cur - (1 << cnt);
                int right = cur + (1 << cnt);
                if (left >= 0) {
                    q.offer(left);
                }
                if (right < arr.length) {
                    q.offer(right);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
