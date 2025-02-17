package Dijkstra.Bellman;

import java.io.*;
import java.util.*;

public class Q1865 {
    static class Road{
        int u, w;
        public Road(int u, int w){
            this.u = u;
            this.w = w;
        }
    }
    static ArrayList<Road>[] graph;
    static int N, M, dist[];
    static final int INF = Integer.MAX_VALUE;

    static boolean bellman(int s){
        Arrays.fill(dist, INF);
        dist[s] = 0;

        boolean flag = false;;

        for(int i=0; i<N-1; i++){
            flag = false;

            for(int j=1; j<=N; j++){
                for(Road r : graph[j]){
                    if(dist[j]!=INF && dist[r.u]>dist[j] + r.w){
                        dist[r.u] = dist[j]+r.w;
                        flag = true;
                    }
                }
            }

            if(!flag) break;
        }

        if(flag){
            for(int i=1; i<=N; i++){
                for(Road r : graph[i]){
                    if(dist[i]!=INF && dist[r.u]>dist[i] + r.w) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (TC-->0) { 
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            dist = new int[N+1];

            for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(new Road(v, w));
                graph[v].add(new Road(u, w));
            }
            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(new Road(v, w));
            }

            boolean isCycle = false;
            for(int i=1; i<=N; i++){
                if(bellman(i)){
                    isCycle = true;
                    sb.append("YES").append("\n");
                    break;
                }
            }

            if(!isCycle) sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
