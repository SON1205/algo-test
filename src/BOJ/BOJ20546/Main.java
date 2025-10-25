package BOJ.BOJ20546;

import java.util.Scanner;

public class Main {
    final static String JUN = "BNP";
    final static String SUNG = "TIMING";
    final static String SAME = "SAMESAME";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int[] prices = new int[14];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        int jun = getProfitByJun(start, prices);
        int sung = getProfitBySung(start, prices);

        if (jun == sung) {
            System.out.println(SAME);
        } else if (jun > sung) {
            System.out.println(JUN);
        } else {
            System.out.println(SUNG);
        }
    }

    private static int getProfitByJun(int start, int[] prices) {
        int zu = 0;

        for (int i = 0; i < prices.length; i++) {
            if (start == 0) {
                break;
            }

            int tmp = start / prices[i];

            if (tmp == 0) {
                continue;
            }

            zu += tmp;
            start -= tmp * prices[i];
        }

        return zu * prices[prices.length - 1] + start;
    }

    private static int getProfitBySung(int start, int[] prices) {
        int zu = 0;

        for (int i = 0; i < prices.length - 3; i++) {
            if (prices[i] > prices[i + 1] && prices[i + 1] > prices[i + 2]) {
                int tmp = start / prices[i + 3];

                if (tmp == 0) {
                    continue;
                }

                zu += tmp;
                start -= tmp * prices[i + 3];
            }

            if (prices[i] < prices[i + 1] && prices[i + 1] < prices[i + 2]) {
                start += prices[i + 3] * zu;
                zu = 0;
            }
        }

        return zu * prices[prices.length - 1] + start;
    }
}
