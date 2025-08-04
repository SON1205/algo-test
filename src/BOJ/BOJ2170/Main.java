package BOJ.BOJ2170;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lines.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        lines.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int result = 0;
        int start = lines.get(0)[0];
        int end = lines.get(0)[1];
        for (int idx = 0; idx < N; idx++) {
            if (lines.get(idx)[0] > end) {
                result += end - start;
                start = lines.get(idx)[0];
                end = lines.get(idx)[1];
            } else {
                end = Math.max(end, lines.get(idx)[1]);
            }
        }

        result += end - start;

        System.out.println(result);
    }
}
