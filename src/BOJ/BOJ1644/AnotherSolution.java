package BOJ.BOJ1644;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 2) 투 포인터로 연속합 개수 세기
        int ans = 0;
        int left = 0, right = 0;
        long sum = 0; // 안전하게 long

        while (true) {
            if (sum >= N) {
                if (sum == N) {
                    ans++;
                }
                sum -= primes.get(left++);
            } else {
                if (right == primes.size()) {
                    break;
                }
                sum += primes.get(right++);
            }
        }

        System.out.println(ans);
    }
}
