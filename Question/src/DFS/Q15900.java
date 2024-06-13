package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15900 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int depth = 0;

    static void dfs(int s, int cnt){
        visited[s] = true;
        for(int i : graph[s]){
            if(!visited[i]){
                dfs(i, cnt+1);
            }
        }

        if(s!=1 && graph[s].size()==1) depth+=cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N+1];
        StringTokenizer st;

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0);

        System.out.println(depth%2==0 ? "No" : "Yes");
    }
}
