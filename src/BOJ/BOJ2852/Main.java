package BOJ.BOJ2852;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scores = new int[3];
        int[] result = new int[3];

        int prev = 0;
        for (int i = 0; i < N; i++) {
            int team = sc.nextInt();
            int time = convertToSeconds(sc.next());

            if (scores[1] > scores[2]) {
                result[1] += time - prev;
            } else if (scores[1] < scores[2]) {
                result[2] += time - prev;
            }

            scores[team]++;
            prev = time;
        }

        if (prev != 48 * 60) {
            int tmp = 48 * 60 - prev;

            if (scores[1] > scores[2]) {
                result[1] += tmp;
            } else if (scores[1] < scores[2]) {
                result[2] += tmp;
            }
        }

        System.out.println(convertToTime(result[1]));
        System.out.println(convertToTime(result[2]));
    }

    private static int convertToSeconds(String time) {
        String[] strings = time.split(":");
        return Integer.parseInt(strings[0]) * 60 + Integer.parseInt(strings[1]);
    }

    private static String convertToTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}
