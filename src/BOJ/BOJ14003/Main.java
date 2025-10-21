package BOJ.BOJ14003;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        int[] lis = new int[N];
        int[] pos = new int[N];

        lis[0] = input[0];
        pos[0] = 0;
        int len = 1;

        for (int i = 1; i < N; i++) {
            int next = input[i];

            if (next > lis[len - 1]) {
                lis[len] = next;
                pos[i] = len;
                len++;
            } else {
                int idx = Arrays.binarySearch(lis, 0, len, next);
                if (idx < 0) {
                    idx = -idx - 1;
                }

                lis[idx] = next;
                pos[i] = idx;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int target = len - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (pos[i] == len) {
                stack.push(input[i]);
                target--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append('\n');
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}
