package BOJ.BOJ2504;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Deque<Character> stack = new ArrayDeque<>();
        int mul = 1;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                mul *= 2;
            } else if (c == '[') {
                stack.push(c);
                mul *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                // 바로 이전 문자가 '('면 기본값 추가
                if (i > 0 && s.charAt(i - 1) == '(') {
                    ans += mul;
                }
                stack.pop();
                mul /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                // 바로 이전 문자가 '['면 기본값 추가
                if (i > 0 && s.charAt(i - 1) == '[') {
                    ans += mul;
                }
                stack.pop();
                mul /= 3;
            } else { // 예상치 못한 문자
                System.out.println(0);
                return;
            }
        }

        System.out.println(stack.isEmpty() ? ans : 0);
    }
}
