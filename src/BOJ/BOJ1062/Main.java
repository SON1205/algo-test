package BOJ.BOJ1062;

import java.util.Scanner;

public class Main {
    static int result = 0;
    static char[] alphabet = {'a', 'c', 'i', 'n', 't'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = sc.next();

            int bitmask = 0;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                bitmask |= (1 << (c - 'a'));
            }

            words[i] = bitmask;
        }

        int known = 0;
        for (int i = 0; i < alphabet.length; i++) {
            known |= (1 << (alphabet[i] - 'a'));
        }

        combi(0, 5, K, known, words);

        System.out.println(result);
    }

    private static void combi(int start, int depth, int K, int known, int[] words) {
        if (depth == K) {
            int count = 0;
            for (int word : words) {
                if ((word & known) == word) {
                    count++;
                }
            }
            result = Math.max(result, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((known & (1 << i)) == 0) {
                combi(i + 1, depth + 1, K, known | (1 << i), words);
            }
        }
    }
}
