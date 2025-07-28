package BOJ.BOJ4949;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Character> stack;
        while (true) {
            String input = sc.nextLine();
            if (input.equals(".")) {
                break;
            }

            stack = new ArrayDeque<>();
            boolean flag = true;
            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
