package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24445 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];
    static int arr[];
    static int cnt;

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        for(int vertex : graph.get(v)) visited[vertex] = false;
        visited[v] = true;
        arr[v] = cnt++;
        q.offer(v);

        while(!q.isEmpty()){
            int u = q.poll();
            for(int vertex : graph.get(u)){
                if(!visited[vertex]){
                    visited[vertex] = true;
                    arr[vertex] = cnt++;
                    q.offer(vertex);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = 1;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n+1];
        arr = new int[n+1];

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

        for(int i=0; i<=n; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
