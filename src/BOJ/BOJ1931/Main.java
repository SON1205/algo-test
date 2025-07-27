package BOJ.BOJ1931;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int result = 1;
        int end = list.get(0)[1];
        for (int i = 1; i < N; i++) {
            int[] next = list.get(i);
            if (next[0] < end) {
                continue;
            }

            end = next[1];
            result++;
        }

        System.out.println(result);
    }
}
