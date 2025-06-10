package BOJ.BOJ1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            map1.put(idx, input);
            map2.put(input, idx);
            idx++;
        }

        while (M-- > 0) {
            String input = sc.next();

            try {
                int index = Integer.parseInt(input);
                System.out.println(map1.get(index));
            } catch (NumberFormatException e) {
                System.out.println(map2.get(input));
            }
        }
    }
}
