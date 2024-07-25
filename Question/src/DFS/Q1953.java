package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1953 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Integer> w = new ArrayList<>();
    static ArrayList<Integer> b = new ArrayList<>();

    static void dfs(int s, int t){
        visited[s] = true;
        if(t==0) w.add(s);
        else b.add(s);

        for(int v : graph[s]){
            if(!visited[v]){
                if(t==0) dfs(v, 1);
                else dfs(v, 0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                int v = Integer.parseInt(st.nextToken());
                graph[i].add(v);
                graph[v].add(i);
            }
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]) dfs(i, 1);
        }

        Collections.sort(w);
        Collections.sort(b);

        StringBuilder sb = new StringBuilder();
        sb.append(b.size()).append("\n");
        for(int i : b) sb.append(i + " ");
        sb.append("\n");

        sb.append(w.size()).append("\n");
        for(int i : w) sb.append(i + " ");
        sb.append("\n");

        System.out.println(sb);
    }
}
