package BOJ.BOJ9012;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String input = sc.next();
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < input.length(); i++) {
                char tmp = input.charAt(i);

                if (tmp == '(' || stack.isEmpty()) {
                    stack.push(tmp);
                    continue;
                }

                if (stack.peek() == '(') {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
