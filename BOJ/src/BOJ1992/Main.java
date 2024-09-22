package BOJ1992;

import java.util.Scanner;

public class Main {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.next();
        }

        checking(input, 0, 0, N);

        System.out.println(result);
    }

    static void checking(String[] input, int r, int c, int length) {
        boolean isValid = true;
        char tmp = input[r].charAt(c);

        for (int i = r; i < r + length; i++) {
            if (!isValid) {
                break;
            }

            for (int j = c; j < c + length; j++) {
                if (tmp != input[i].charAt(j)) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            result.append(tmp);
            return;
        }

        result.append("(");
        checking(input, r, c, length / 2);
        checking(input, r, c + length / 2, length / 2);
        checking(input, r + length / 2, c, length / 2);
        checking(input, r + length / 2, c + length / 2, length / 2);
        result.append(")");
    }
}
