package BOJ.BOJ13305;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dis = new int[N - 1];
        int[] price = new int[N];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = sc.nextInt();
        }
        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }

        long result = 0;
        long minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            result += minPrice * dis[i];
        }

        System.out.println(result);
    }
}
