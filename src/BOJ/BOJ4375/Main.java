package BOJ.BOJ4375;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int rest = 1 % n;
            int len = 1;

            while (rest != 0) {
                rest = (rest * 10 + 1) % n;
                len++;
            }

            System.out.println(len);
        }
    }
}
