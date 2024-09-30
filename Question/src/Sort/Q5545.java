package Sort;

import java.io.*;
import java.util.*;

public class Q5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        Integer[] cals = new Integer[N]; // 토핑의 열량 저장 배열

        for (int i = 0; i < N; i++) cals[i] = Integer.parseInt(br.readLine());

        Arrays.sort(cals, Collections.reverseOrder());

        int cost = a;
        int cal = c;
        int best = cal / cost;

        for (int i = 0; i < N; i++) {
            int k = i + 1;
            cost = a + b * k;
            cal += cals[i];
            int cur = cal / cost;

            if (best <= cur) {
                best = cur;
            } else {
                break;
            }
        }

        System.out.println(best);
    }
}
