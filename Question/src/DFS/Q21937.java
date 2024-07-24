package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21937 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt = 0;
    static boolean flag;

    static void dfs(int s){
        visited[s] = true;

        for(int i : graph[s]){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[v].add(u);
        }
        int X = Integer.parseInt(br.readLine());

        dfs(X);
        
        System.out.println(cnt);
    }
}
