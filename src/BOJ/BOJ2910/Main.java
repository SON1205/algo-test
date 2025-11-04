package BOJ.BOJ2910;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        for (Entry<Integer, Integer> l : list) {
            for (int i = 0; i < l.getValue(); i++) {
                sb.append(l.getKey()).append(" ");
            }
        }

        System.out.println(sb);
    }
}
