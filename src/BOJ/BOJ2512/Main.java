package BOJ.BOJ2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            prices.add(sc.nextInt());
        }
        int limit = sc.nextInt();

        Collections.sort(prices);
        int start = 0;
        int end = prices.get(prices.size() - 1) + 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (calculate(prices, mid) <= limit) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }

    private static int calculate(List<Integer> prices, int mid) {
        int total = 0;
        for (int i = 0; i < prices.size(); i++) {
            if (mid < prices.get(i)) {
                total += mid;
            } else {
                total += prices.get(i);
            }
        }
        return total;
    }
}
