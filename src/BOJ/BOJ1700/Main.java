package BOJ.BOJ1700;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 멀티탭 구멍 개수
        int K = sc.nextInt();   // 전기용품 사용 횟수

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> plugged = new ArrayList<>(); // 현재 꽂혀 있는 기기들
        boolean[] used = new boolean[101];         // used[x] == true면 x가 꽂혀 있음
        int unplugCnt = 0;

        for (int i = 0; i < K; i++) {
            int cur = arr[i];

            // 이미 꽂혀 있으면 그대로 사용
            if (used[cur]) {
                continue;
            }

            // 아직 멀티탭에 자리가 남으면 그냥 꽂기
            if (plugged.size() < N) {
                plugged.add(cur);
                used[cur] = true;
                continue;
            }

            // 자리가 없으면 하나 빼야 함
            // -> 가장 나중에 다시 쓰이거나, 다시는 안 쓰이는 기기 선택
            int removeDevice = -1;
            int latestIndex = -1;

            for (int device : plugged) {
                int nextIndex = INF;

                // device가 다음에 언제 다시 쓰이는지 찾기
                for (int j = i + 1; j < K; j++) {
                    if (arr[j] == device) {
                        nextIndex = j;
                        break;
                    }
                }

                // 가장 나중에 쓰이는(또는 안 쓰이는) 기기를 뽑을 후보로 선택
                if (nextIndex > latestIndex) {
                    latestIndex = nextIndex;
                    removeDevice = device;
                }
            }

            // 해당 기기 뽑기
            used[removeDevice] = false;
            unplugCnt++;
            // 리스트에서 제거
            plugged.remove(Integer.valueOf(removeDevice));

            // 새 기기 꽂기
            plugged.add(cur);
            used[cur] = true;
        }

        System.out.println(unplugCnt);
    }
}
