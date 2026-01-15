package BOJ.BOJ13335;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = sc.nextInt();
        }

        Deque<Integer> q = new ArrayDeque<>();
        int total = trucks[0];
        int idx = 0;
        q.offer(trucks[idx++]);
        int result = 1;
        while (true) {
            if (q.isEmpty()) {
                break;
            }

            if (result >= w) {
                total -= q.poll();
            }

            result++;

            if (idx >= n) {
                continue;
            }

            if (total + trucks[idx] <= L) {
                total += trucks[idx];
                q.offer(trucks[idx++]);
            } else {
                q.offer(0);
            }
        }

        System.out.println(result);

        Deque<Integer> bridge = new ArrayDeque<>();

        // 다리를 빈 칸으로 초기화
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

//        int time = 0;
//        int idx = 0;
//        int weightSum = 0;
//
//        while (idx < n) {
//            // 1. 시간 경과 → 앞 칸 제거
//            weightSum -= bridge.poll();
//
//            // 2. 다음 트럭을 올릴 수 있으면 올림
//            if (weightSum + trucks[idx] <= L) {
//                bridge.offer(trucks[idx]);
//                weightSum += trucks[idx];
//                idx++;
//            } else {
//                bridge.offer(0);
//            }
//
//            time++;
//        }
//
//        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
//        time += w;
//
//        System.out.println(time);
    }
}
