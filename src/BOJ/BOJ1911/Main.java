package BOJ.BOJ1911;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        List<int[]> waters = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            waters.add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        waters.sort(Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int covered = 0;
//        int idx = 0;
//        while (idx < N) {
//            int[] cur = waters.get(idx);
//
//            while (covered < cur[1]) {
//                if (covered < cur[0]) {
//                    covered = cur[0] + L;
//                    result++;
//                    continue;
//                }
//
//                covered += L;
//                result++;
//            }
//
//            idx++;
//        }

        for (int i = 0; i < waters.size(); i++) {
            int s = waters.get(i)[0];
            int e = waters.get(i)[1];

            int start = Math.max(covered, s);
            if (start < e) {
                int need = (e - start + L - 1) / L;
                result += need;
                covered = start + need * L;
            }
        }

        System.out.println(result);
    }
}
