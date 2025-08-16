package BOJ.BOJ2343;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 10_000 * 100_000;
        for (int i = 0; i < N; i++) {
            int next = sc.nextInt();
            list.add(next);
            left = Math.max(left, next);
            right += next;
        }
        
        while (left < right) {
            int mid = (left + right) / 2;

            int sum = 0;
            int cnt = 1;
            for (Integer s : list) {
                if (sum + s > mid) {
                    cnt++;
                    sum = s;
                } else {
                    sum += s;
                }
            }

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}
