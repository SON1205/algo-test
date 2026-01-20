package BOJ.BOJ10800;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int color = sc.nextInt();
            int size = sc.nextInt();
            arr.add(new int[]{color, size, i});
        }

        arr.sort(Comparator.comparingInt(a -> a[1]));

        int[] answer = new int[N];
        int[] colorSum = new int[N + 1];
        int total = 0;

        int j = 0;
        for (int i = 0; i < N; i++) {
            int[] cur = arr.get(i);

            // 나보다 작은 공들만 누적
            while (arr.get(j)[1] < cur[1]) {
                int[] small = arr.get(j);
                total += small[1];
                colorSum[small[0]] += small[1];
                j++;
            }

            answer[cur[2]] = total - colorSum[cur[0]];
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
