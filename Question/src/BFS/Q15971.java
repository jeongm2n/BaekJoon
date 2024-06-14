package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15971 {
    static class Node{
        int d, w, max;
        public Node(int d, int w, int max){
            this.d = d;
            this.w = w;
            this.max = max;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;

    static void bfs(int s, int e){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0, 0));
        visited[s] = true;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.d==e){
                System.out.println(n.w-n.max);
                System.exit(0);
            }

            for(Node p : graph[n.d]){
                if(!visited[p.d]){
                    visited[p.d] = true;
                    int max = Math.max(n.max, p.w);
                    q.offer(new Node(p.d, n.w+p.w, max));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w, 0));
            graph[v].add(new Node(u, w, 0));
        }

        bfs(r1,r2);
    }
}
