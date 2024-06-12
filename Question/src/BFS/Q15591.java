package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15591 {
    static class Node{
        int d;
        long w;
        public Node(int d, long w){
            this.d = d;
            this.w = w;
        }
    }

    static int N;
    static ArrayList<Node>[] graph;
    static boolean[] visited;

    static int dijkstra(int s, long K){
        visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        int result = 0;

        while(!q.isEmpty()){
            int n = q.poll();

            for(Node c : graph[n]){
                int d = c.d;
                long w = c.w;
                if(!visited[d] && w>=K){
                    result++;
                    q.offer(d);
                    visited[d] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q;i ++){
            st = new StringTokenizer(br.readLine());
            long k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(dijkstra(v, k)).append("\n");
        }

        System.out.println(sb);
    }
}
