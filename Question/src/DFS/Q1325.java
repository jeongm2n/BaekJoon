package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1325 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int[] com;

    static void dfs(int s){
        visited[s] = true;

        for(int v : graph[s]){
            if(!visited[v]){
                com[v]++;
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        int max = Integer.MIN_VALUE;
        com = new int[N+1];

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            dfs(i);
        }

        for(int i=1; i<=N; i++)  max = Math.max(com[i], max);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) if(com[i]==max) sb.append(i + " ");

        System.out.println(sb);
    }
}
