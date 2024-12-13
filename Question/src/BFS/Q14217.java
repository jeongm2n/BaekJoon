package BFS;

import java.io.*;
import java.util.*;

public class Q14217 {
    static class Node{
        int v, w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] city;

    static void bfs(){
        visited = new boolean[N+1];
        city = new int[N+1];

        Arrays.fill(city, -1);
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        visited[1] = true;
        city[1] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int v = cur.v;
            int w = cur.w;

            for(int u : graph[v]){
                if(!visited[u]){
                    q.offer(new Node(u, w+1));
                    city[u] = w+1;
                    visited[u] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int q = Integer.parseInt(br.readLine());
        for(int z=0; z<q; z++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(a==1){
                graph[i].add(j);
                graph[j].add(i);
            }
            if(a==2){
                graph[i].remove(Integer.valueOf(j));
                graph[j].remove(Integer.valueOf(i));
            }
            bfs();
            for(int r=1; r<=N; r++) sb.append(city[r] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
