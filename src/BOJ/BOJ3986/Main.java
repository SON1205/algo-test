package BOJ.BOJ3986;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                if (stack.isEmpty() || c != stack.peek()) {
                    stack.push(c);
                    continue;
                }

                stack.poll();
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);
    }
}
