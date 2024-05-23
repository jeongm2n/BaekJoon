package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2644 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int result = -1;

    static void dfs(int x, int y, int cnt){
        if(y==x){
            result = cnt;
            return;
        }

        visited[y] = true;

        for(int v : graph[y]){
            if(!visited[v]) dfs(x, v, cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Integer>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int z = Integer.parseInt(br.readLine());

        for(int i=1; i<=z; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(x, y, 0);

        System.out.println(result);
    }
}
