package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18223 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
    static int V;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static final int INF = 5000 * 10000 + 1;

    static int dijkstra(int s, int e){
        if(s==e) return 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        dist = new int[V+1];
        Arrays.fill(dist, INF);

        q.offer(new Node(s, 0));
        dist[s] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(Node n : graph[cur.d]){
                int d = n.d;
                int w = n.w;

                if(dist[d] > dist[cur.d] + w){
                    dist[d] = dist[cur.d] + w;
                    q.offer(new Node(d, dist[d]));
                }
            }
        }

        return dist[e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }

        System.out.println(dijkstra(1, V) == dijkstra(1, P) + dijkstra(P, V) ? "SAVE HIM" : "GOOD BYE");
    }
}
