package BOJ.BOJ1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long num = 0;
        while (true) {
            String number = String.valueOf(num);
            boolean flag = false;
            for (int i = 0; i < number.length() - 2; i++) {
                if (number.charAt(i) == '6' && number.charAt(i + 1) == '6' && number.charAt(i + 2) == '6') {
                    flag = true;
                    N--;

                    if (N == 0) {
                        System.out.println(number);
                        return;
                    }

                    num++;
                    break;
                }
            }

            if (!flag) {
                num++;
            }
        }
    }
}
