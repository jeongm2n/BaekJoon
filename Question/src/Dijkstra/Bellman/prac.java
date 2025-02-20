package Dijkstra.Bellman;

import java.io.*;
import java.util.*;

public class prac {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static void bellman(){
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean isCycle = false;

        for(int i=0; i<N-1; i++){
            for(Edge edge : edges){
                int s = edge.s;
                int e = edge.e;
                int w = edge.w;

                if(dist[s]!=INF && dist[e]>dist[s]+w) dist[e] = dist[s]+w;
            }
        }

        for(Edge edge : edges){
            int s = edge.s;
            int e = edge.e;
            int w = edge.w;

            if(dist[s]!=INF && dist[e]>dist[s]+w){
                dist[e] = dist[s]+w;
                isCycle = true;
            }
        }

        System.out.println(isCycle ? "음수 사이클이 존재합니다!" : "음수 사이클이 존재하지 않습니다.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, w));
        }

        bellman();
    }
}
