package DFS;

import java.io.*;
import java.util.*;

public class Q1068 {
    static ArrayList<Integer>[] graph;
    static int del, answer=0;
    static boolean[] visited;

    static void dfs(int v){
        visited[v] = true;
        int nodes = 0;
        for (int cur : graph[v]) {
            if (cur != del && !visited[cur]) {
                nodes++;
                dfs(cur);
            }
        }
        if (nodes == 0) answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = 0;

        for(int i=0; i<N; i++){
            int u = Integer.parseInt(st.nextToken());
            if(u==-1){
                root = i;
                continue;
            }

            graph[u].add(i);
            graph[i].add(u);
        }

        del = Integer.parseInt(br.readLine());
        if(del==root) System.out.println(0);
        else {
            dfs(root);
            System.out.println(answer);
        }
    }
}
