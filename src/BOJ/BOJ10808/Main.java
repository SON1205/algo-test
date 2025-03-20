package BOJ.BOJ10808;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();

        int[] result = new int[26];
        int compare = 'a';

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (compare == input[j]) {
                    result[i]++;
                }
            }

            compare++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
