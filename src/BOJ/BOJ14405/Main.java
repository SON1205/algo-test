package BOJ.BOJ14405;

import java.util.Scanner;

public class Main {
    static String[] words = {"pi", "ka", "chu"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int idx = 0;
        while (true) {
            if (idx >= input.length()) {
                break;
            }

            boolean flag = false;
            for (int i = 0; i < words.length; i++) {
                int tmp = idx + words[i].length();
                if (tmp >= input.length()) {
                    tmp = input.length();
                }

                if (words[i].equals(input.substring(idx, tmp))) {
                    idx += words[i].length();
                    flag = true;
                }
            }

            if (!flag) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
