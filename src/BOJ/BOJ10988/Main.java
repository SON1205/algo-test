package BOJ.BOJ10988;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int size = input.length();

        boolean isPalindrome = true;
        for (int i = 0; i <= size / 2; i++) {
            if (input.charAt(i) != input.charAt(size - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
