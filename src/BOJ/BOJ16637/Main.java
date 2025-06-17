package BOJ.BOJ16637;

import java.util.Scanner;

public class Main {
    static int[] nums;
    static char[] ops;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        nums = new int[N / 2 + 1];
        ops = new char[N / 2];

        String input = sc.next();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(input.charAt(i) + "");
            } else {
                ops[i / 2] = input.charAt(i);
            }
        }

        dfs(1, nums[0], null);

        System.out.println(result);
    }

    private static void dfs(int idx, int total, Integer prev) {
        if (idx >= nums.length) {
            result = Math.max(result, total);
            return;
        }

        if (prev != null) {
            int tempSum = calculate(prev, idx);
            dfs(idx + 1, calculate(total, tempSum, idx), null);
            return;
        }

        if (idx != nums.length - 1) {
            dfs(idx + 1, total, nums[idx]);
        }
        dfs(idx + 1, calculate(total, idx), null);
    }

    private static int calculate(Integer prev, int idx) {
        if (ops[idx - 1] == '+') {
            return prev + nums[idx];
        } else if (ops[idx - 1] == '-') {
            return prev - nums[idx];
        } else {
            return prev * nums[idx];
        }
    }

    private static int calculate(int total, int group, int idx) {
        if (ops[idx - 2] == '+') {
            return total + group;
        } else if (ops[idx - 2] == '-') {
            return total - group;
        } else {
            return total * group;
        }
    }
}

/*
        static void dfs(int idx, int sum) {
            if (idx >= ops.length) {
                result = Math.max(result, sum);
                return;
            }

            // 1. 이번 연산에 괄호를 묶지 않고 진행
            int temp = calc(sum, nums[idx + 1], ops[idx]);
            dfs(idx + 1, temp);

            // 2. 다음 연산에 괄호를 묶을 수 있다면, 먼저 묶어서 계산
            if (idx + 1 < ops.length) {
                int next = calc(nums[idx + 1], nums[idx + 2], ops[idx + 1]);
                dfs(idx + 2, calc(sum, next, ops[idx]));
            }
        }

        static int calc(int a, int b, char op) {
            if (op == '+') return a + b;
            else if (op == '-') return a - b;
            else return a * b;
        }
 */
