package BOJ.BOJ10828;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        while (N-- > 0) {
            String input = sc.next();
            switch (input) {
                case "push" -> {
                    stack.push(sc.nextInt());
                }
                case "pop" -> {
                    if (!stack.isEmpty()) {
                        int popped = stack.pop();
                        System.out.println(popped);
                    } else {
                        System.out.println(-1);
                    }
                }
                case "top" -> {
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println(-1);
                    }
                }
                case "empty" -> {
                    System.out.println(stack.isEmpty() ? 1 : 0);
                }
                case "size" -> {
                    System.out.println(stack.size());
                }
            }
        }
    }
}
