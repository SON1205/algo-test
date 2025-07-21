package BOJ.BOJ15926;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    visited[i] = true;
                    visited[stack.pop()] = true;
                }
            }
        }

        int tmp = 0;
        for (boolean b : visited) {
            if (b) {
                tmp++;
            } else {
                result = Math.max(result, tmp);
                tmp = 0;
            }
        }
        result = Math.max(result, tmp);

        System.out.println(result);
    }
}
