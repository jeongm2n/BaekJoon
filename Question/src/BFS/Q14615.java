package BFS;

import java.io.*;
import java.util.*;

public class Q14615 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static boolean bfs(int s, int e){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : graph[cur]){
                if(visited[v]) continue;
                if(v==e) return true;    
                else{
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph[X].add(Y);
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int C = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            boolean result1 = bfs(1, C);
            visited = new boolean[N+1];
            boolean result2 = bfs(C, N);
            
            sb.append(result1&&result2 ? "Defend the CTP" : "Destroyed the CTP").append("\n");
        }

        System.out.println(sb);
    }   
}
