package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20007 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int N, X, result=1;

    static void dijkstra(int Y){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        visited[Y] = true;
        dist[Y] = 0;
        pq.offer(new Node(Y, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(Node n : graph[cur.d]){
                if(!visited[n.d] && dist[n.d]>dist[cur.d]+n.w){
                    dist[n.d] = dist[cur.d]+n.w;
                    visited[n.d] = true;
                    pq.offer(new Node(n.d, dist[n.d]));
                }
            }
        }
    }

    static void chk(){
        int total = 0;
    
        for(int i=0; i<N; i++){
            if(dist[i]*2>X){
                result = -1;
                return;
            }

            total += dist[i]*2;
            
            if(total>X){
                result++;
                total = dist[i]*2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        dist = new int[N];
        visited = new boolean[N];
        graph = new ArrayList[N];

        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        dijkstra(Y);
        Arrays.sort(dist);
        chk();

        System.out.println(result);
    }
}
