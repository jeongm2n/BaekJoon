package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11724 {
    static int[][] graph;
    static boolean[] visited;

    static int n;

    static void dfs(int start){
        visited[start] = true;

        for(int i=1; i<=n; i++){
            if(graph[start][i]==1 && !visited[i]) dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int result = 0;

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }
}
