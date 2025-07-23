package BOJ.BOJ1874;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int num = 1, idx = 0;

        while (idx < n) {
            if (!stack.isEmpty() && stack.peek() == seq[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            } else if (num <= n) {
                stack.push(num++);
                sb.append("+\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);
    }
}
