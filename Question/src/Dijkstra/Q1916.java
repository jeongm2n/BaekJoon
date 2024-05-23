package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1916 {
    static class Bus{
        int d;
        int w;
        public Bus(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Bus>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    static void dijkstra(int s, int e){
        PriorityQueue<Bus> pq = new PriorityQueue<>((o1,o2)->{
            return o1.w - o2.w;
        });

        dist[s] = 0;
        pq.offer(new Bus(s,0));

        while(!pq.isEmpty()){
            Bus b = pq.poll();

            if(!visited[b.d]){
                visited[b.d] = true;

                for(Bus node : graph[b.d]){
                    int d = node.d;
                    int w = node.w;
                    if(!visited[d] && dist[d]>dist[b.d]+w){
                        dist[d] = dist[b.d] + w;
                        pq.offer(new Bus(d, dist[d]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];

        Arrays.fill(dist, INF);

        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Bus>();

        StringTokenizer st;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Bus(e, w));
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s,e);

        System.out.println(dist[e]);
    }
}
