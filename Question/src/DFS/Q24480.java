package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24480 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb;
    static int[] arr;
    static int idx;

    public static void dfs(int v){
        visited[v] = true;
        arr[v] = idx++;
        Collections.sort(graph.get(v),Collections.reverseOrder());
        for(int vertex : graph.get(v)){
            if(!visited[vertex]) dfs(vertex);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[n+1];
        idx = 1;

        graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(r);
        for(int i=1; i<=n; i++){
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb);
    }
}
