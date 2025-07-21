package BOJ.BOJ15926;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();

        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (!stack.isEmpty()) {
                    int length = i - stack.peek();
                    result = Math.max(result, length);
                } else {
                    //분기점
                    stack.push(i);
                }
            }
        }

        System.out.println(result);
    }
}
