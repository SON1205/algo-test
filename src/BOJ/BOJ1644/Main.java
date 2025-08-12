package BOJ.BOJ1644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        int result = 0;
        int start = 0;
        while (start < primes.size()) {
            int tmp = 0;
            int cnt = 0;
            while (start + cnt < primes.size()) {
                tmp += primes.get(start + cnt);
                if (tmp >= N) {
                    if (tmp == N) {
                        result++;
                    }
                    break;
                } else {
                    cnt++;
                }
            }

            start++;
        }

        System.out.println(result);
    }
}
