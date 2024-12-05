package BFS;

import java.io.*;
import java.util.*;

public class Q21738 {
    static int N, S, P, result;
    static ArrayList<Integer>[] graph;

    private static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(s);
        visited[s] = true;

        int depth = -1;
        int cnt = 0;
        
        while (!q.isEmpty() && cnt < 2) {
            depth++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int num = q.poll();
                if (num <= S && cnt < 2) {
                    result -= depth;
                    cnt++;
                    continue;
                }

                for (int next : graph[num]) {
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()); 
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        result = N-1;

        bfs(P);
        System.out.println(result);
    }
}
