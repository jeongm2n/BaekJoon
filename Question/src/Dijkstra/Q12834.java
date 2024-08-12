package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12834 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static int[] dist;
    static int V, A, B;
    static ArrayList<Node>[] graph;
    static final int INF = 100000001;

    static int bfs(int s){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        dist = new int[V+1];

        Arrays.fill(dist, INF);
        dist[s] = 0;
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(Node next : graph[cur.d]){
                if(dist[next.d]>dist[cur.d] + next.w){
                    dist[next.d] = dist[cur.d] + next.w;
                    q.offer(new Node(next.d, dist[next.d]));
                }
            }
        }

        return chk(dist[A]) + chk(dist[B]);
    }

    static int chk(int x){
        if(x==INF) return -1;
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) home[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int sum = 0;

        for(int i=0; i<N; i++){
            sum += bfs(home[i]);
        }

        System.out.println(sum);
    }   
}
