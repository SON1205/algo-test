package BOJ.BOJ9935;

import java.util.Scanner;

public class Main {
    static final String NO_REMAIN = "FRULA";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String bomb = sc.next();
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            sb.append(c);

            if (sb.length() >= bomb.length()) {
                boolean flag = true;

                for (int i = 0; i < bomb.length(); i++) {
                    if (sb.charAt(sb.length() - bomb.length() + i) != bomb.charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        System.out.println(sb.isEmpty() ? NO_REMAIN : sb.toString());
    }
}
