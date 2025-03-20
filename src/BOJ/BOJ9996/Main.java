package BOJ.BOJ9996;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String regEx = sc.next();
        String prefix = regEx.substring(0, findPrefix(regEx));
        String suffix = regEx.substring(findPrefix(regEx) + 1);

        for (int i = 0; i < N; i++) {
            boolean yesOrNo = false;

            String input = sc.next();

            if (input.indexOf(prefix) == 0 && input.lastIndexOf(suffix) >= prefix.length() && input.lastIndexOf(suffix) == input.length() - suffix.length()) {
                yesOrNo = true;
            }

            if (yesOrNo) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

    private static int findPrefix(String regEx) {
        for (int i = 0; i < regEx.length(); i++) {
            if (regEx.charAt(i) == 42) {
                return i;
            }
        }

        return -1;
    }
}
