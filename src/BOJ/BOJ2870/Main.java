package BOJ.BOJ2870;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            Deque<Character> q = new ArrayDeque<>();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) >= 'a' && input.charAt(j) <= 'z') {
                    if (q.isEmpty()) {
                        continue;
                    }

                    String num = getNum(concatNum(q));
                    list.add(num);

                    continue;
                }

                q.offer(input.charAt(j));
            }

            if (!q.isEmpty()) {
                String num = getNum(concatNum(q));
                list.add(num);
            }
        }

        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static String concatNum(Deque<Character> q) {
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            sb.append(q.poll());
        }
        return sb.toString();
    }

    private static String getNum(String num) {
        if (num.startsWith("0")) {
            int idx = 0;
            for (int i = 1; i < num.length(); i++) {
                if (num.charAt(i) != '0') {
                    break;
                }

                idx++;
            }

            if (idx + 1 == num.length()) {
                return "0";
            }

            num = num.substring(idx + 1);
        }

        return num;
    }
}
