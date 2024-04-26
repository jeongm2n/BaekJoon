package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {
    static class Node{
        int d;
        int w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static final int INF = 200000000;

    static int dijkstra(int start, int end){
        Arrays.fill(dist,INF);
        Arrays.fill(visited,false);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node pqNode = pq.poll();

            if(!visited[pqNode.d]){
                visited[pqNode.d] = true;
                for(Node newNode : graph[pqNode.d]){
                    int d = newNode.d;
                    int w = newNode.w;
                    if(!visited[d] && dist[d]>dist[pqNode.d]+w){
                        dist[d] = dist[pqNode.d] + w;
                        pq.offer(new Node(d,dist[d]));
                    }
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
            graph[v].add(new Node(u,w));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int dist1 = 0;
        dist1 += dijkstra(1, a);
        dist1 += dijkstra(a, b);
        dist1 += dijkstra(b, n);

        int dist2 = 0;
        dist2 += dijkstra(1, b);
        dist2 += dijkstra(b, a);
        dist2 += dijkstra(a, n);

        System.out.println(dist1>=INF && dist2>=INF ? -1 : Math.min(dist1,dist2));
    }
}
