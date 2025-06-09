package BOJ.BOJ9375;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int result = 1;
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String item = sc.next();
                String category = sc.next();

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            for (Integer value : map.values()) {
                result *= value + 1;
            }

            System.out.println(result - 1);
        }
    }
}
