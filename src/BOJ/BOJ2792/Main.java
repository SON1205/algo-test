package BOJ.BOJ2792;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list.add(sc.nextInt());
        }

        // 니눠주는 최대 개수
        int left = 1;
        int right = 1_000_000_000;
        while (left < right) {
            int mid = (left + right) / 2;
            int tmp = 0;
            for (int i = 0; i < list.size(); i++) {
                tmp += (list.get(i) + mid - 1) / mid;
            }

            if (tmp > N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right);
    }
}
