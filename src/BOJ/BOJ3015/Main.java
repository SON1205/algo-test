package BOJ.BOJ3015;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<int[]> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int count = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                int[] top = stack.pop();
                result += top[1];

                if (top[0] == height) {
                    count += top[1];
                }
            }

            if (!stack.isEmpty()) {
                result += 1;
            }

            stack.push(new int[]{height, count});
        }

        System.out.println(result);
    }
}
