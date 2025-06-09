package BOJ.BOJ1213;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int[] alphabets = new int[26];
        int oddCount = 0;
        char oddChar = 0;

        for (char c : input.toCharArray()) {
            alphabets[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabets[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(half);
        if (oddCount == 1) {
            answer.append(oddChar);
        }
        answer.append(half.reverse());

        System.out.println(answer);
    }
}