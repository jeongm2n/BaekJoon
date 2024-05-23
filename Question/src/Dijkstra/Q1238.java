package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1238 {
    static class Road{
        int d;
        int w;
        public Road(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Road>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int n;

    static int dijkstra(int s, int party){
        PriorityQueue<Road> q = new PriorityQueue<>((o1,o2)->{
            return o1.w - o2.w;
        });

        visited = new boolean[n+1];
        dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        visited[s] = true;
        q.offer(new Road(s, 0));
        dist[s] = 0;

        while(!q.isEmpty()){
            Road r = q.poll();
            visited[r.d] = true;

            for(Road node : graph[r.d]){
                int d = node.d;
                int w = node.w;

                if(!visited[d] && dist[d]>dist[r.d]+w){
                    dist[d] = dist[r.d]+w;
                    q.offer(new Road(d, dist[d]));
                }
            }
        }

        return dist[party];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Road>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Road(v, w));
        }
        int max = 0;

        for(int i=1; i<=n; i++){
            if(i!=x){
                int distance = dijkstra(i, x) + dijkstra(x, i);
                max = Math.max(max, distance);
            }
        }

        System.out.println(max);
    }
}
