package Dijkstra;

import java.io.*;
import java.util.*;

public class Q14938 {
    static int n, m, items[], dist[];
    static ArrayList<Node>[] graph; 

    static class Node{
        int v, w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int dijkstra(int s){
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        q.offer(new Node(s, 0));
        int result = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(dist[cur.v] < cur.w) continue;

            result += items[cur.v];

            for(Node n : graph[cur.v]){
                int v = n.v;
                int w = n.w;

                if(dist[v] > dist[cur.v]+w && dist[cur.v]+w <= m){
                    dist[v] = dist[cur.v]+w;
                    q.offer(new Node(v, dist[v]));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        dist = new int[n+1];
        graph = new ArrayList[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int answer = 0;

        for(int i=1; i<=n; i++) answer = Math.max(answer, dijkstra(i));

        System.out.println(answer);
    }
}
