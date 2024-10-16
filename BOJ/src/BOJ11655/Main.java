package BOJ11655;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            if ('A' <= input[i] && input[i] <= 'Z') {
                input[i] = (char) ((input[i] - 'A' + 13) % 26 + 'A');
            } else if ('a' <= input[i] && input[i] <= 'z') {
                input[i] = (char) ((input[i] - 'a' + 13) % 26 + 'a');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
