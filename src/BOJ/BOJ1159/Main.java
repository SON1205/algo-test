package BOJ.BOJ1159;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Character, Integer> input = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char first = sc.next().charAt(0);

            input.put(first, input.getOrDefault(first, 0) + 1);
        }

        List<Character> result = new ArrayList<>();

        for (Character c : input.keySet()) {
            if (input.get(c) >= 5) {
                result.add(c);
            }
        }

        if (result.size() == 0) {
            System.out.println("PREDAJA");
        } else {
            Collections.sort(result);

            StringBuilder sb = new StringBuilder();
            for (Character c : result) {
                sb.append(c);
            }

            System.out.println(sb);
        }
    }
}
