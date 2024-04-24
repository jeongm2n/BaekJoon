package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int cnt;

    static void dfs(int v){
        visited[v] = true;
        for(int vertex : graph.get(v)){
            if(!visited[vertex]){
                cnt++;
                dfs(vertex);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        visited = new boolean[n+1];
        cnt = 0;
        graph = new ArrayList<>();
        
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);
        System.out.println(cnt);

    }
}
