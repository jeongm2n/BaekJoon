package DFS;

import java.util.*;
import java.io.*;

public class Q15270 {
    static int N, M, max;
    static int[][] graph;
    static boolean[] visited;

    static void find(int idx, int cnt) {

        if (idx >= M) {
            max = Math.max(max, cnt);
            return;
        }

        if (visited[graph[idx][0]] || visited[graph[idx][1]]) {
            find(idx + 1, cnt);
        } else {
            visited[graph[idx][0]] = true;
            visited[graph[idx][1]] = true;

            find(idx + 1, cnt + 1);

            visited[graph[idx][0]] = false;
            visited[graph[idx][1]] = false;

            find(idx + 1, cnt);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M][2];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        visited = new boolean[N + 1];

        find(0, 0);

        max *=2;

        if (max < N) {
            max++;
        }

        System.out.println(max);
    }
}
