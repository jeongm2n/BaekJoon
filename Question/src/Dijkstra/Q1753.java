package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {
    static class Node{
        int v;
        int w;
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Node>[] graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        for(int i=1; i<=n; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.w - o2.w;
        });
        pq.offer(new Node(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.v]) continue;
            visited[node.v] = true;
            
            for(int i=0; i<graph[node.v].size(); i++){
                Node nn = graph[node.v].get(i);
                int v = nn.v;
                int w = nn.w;

                if(dist[v] > dist[node.v]+w){
                    dist[v] = dist[node.v] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}
