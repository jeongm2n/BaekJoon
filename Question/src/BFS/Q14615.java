package BFS;

import java.io.*;
import java.util.*;

public class Q14615 {
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] regraph;
    static boolean[][] visited;
    static int N, M, C;

    static class Node{
        int v;
        boolean f;
        public Node(int v, boolean f){
            this.v = v;
            this.f = f;
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[0][1] = true;
        visited[1][N] = true;
        q.offer(new Node(1, false));
        q.offer(new Node(N, true));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int v = cur.v;
            boolean f = cur.f;

            if(f){
                for(int u : regraph[v]){
                    if(!visited[1][u]){
                        visited[1][u] = true;
                        q.offer(new Node(u, true));
                    }
                }
            }else{
                for(int u : graph[v]){
                    if(!visited[0][u]){
                        visited[0][u] = true;
                        q.offer(new Node(u, false));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        regraph = new ArrayList[N+1];
        visited = new boolean[2][N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
            regraph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph[X].add(Y);
            regraph[Y].add(X);
        }

        StringBuilder sb = new StringBuilder();

        bfs();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            C = Integer.parseInt(br.readLine());    
            sb.append(visited[0][C]&&visited[1][C] ? "Defend the CTP" : "Destroyed the CTP").append("\n");
        }

        System.out.println(sb);
    }   
}
