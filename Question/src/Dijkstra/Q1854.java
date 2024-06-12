package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1854 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
    static int n;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Integer>[] dist;

    static void dijkstra(int k){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        dist[1].add(0);

        while(!q.isEmpty()){
            Node n = q.poll();

            for(Node c : graph[n.d]){
                int d = c.d;
                int w = c.w;
                
                if(dist[d].size()<k){
                    dist[d].add(n.w+w);
                    q.offer(new Node(d, n.w+w));
                }else if(dist[d].peek()>n.w+w){
                    dist[d].poll();
                    dist[d].add(n.w+w);
                    q.offer(new Node(d, n.w+w));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        dist = new PriorityQueue[n+1];
        

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        for(int i=1; i<=n; i++) Collections.sort(graph[i], (o1,o2)->{return o2.w-o1.w;});

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++){
            if(dist[i].size()<k) sb.append(-1).append("\n");
            else sb.append(dist[i].peek()).append("\n");
        }

        System.out.println(sb);
    }
}
