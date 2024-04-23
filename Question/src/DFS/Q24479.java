package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24479 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] arr;
    static int cnt;

    public static void dfs(int v){
        arr[v] = cnt++;
        visited[v] = true;
        for(int vertex : graph.get(v)){
            if(!visited[vertex]){
                dfs(vertex);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
        visited = new boolean[n+1];
        arr = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        dfs(r);

        for(int i=1; i<=n; i++){
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
