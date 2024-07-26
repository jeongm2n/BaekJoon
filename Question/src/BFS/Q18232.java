package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18232 {
    static class Node{
        int x, w;
        public Node(int x, int w){
            this.x = x;
            this.w = w;
        }
    }
    static int[] graph;
    static boolean[] visited;
    static int N;
    static int[] dx = {1,-1};

    static int bfs(int S, int E){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(S, 0));
        visited[S] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==E) return cur.w;

            for(int i=0; i<2; i++){
                int nx = cur.x + dx[i];
                if(range(nx) && !visited[nx]){
                    q.offer(new Node(nx, cur.w+1));
                    visited[nx] = true;
                }
            }
            if(graph[cur.x]!=0 && !visited[graph[cur.x]]){
                q.offer(new Node(graph[cur.x], cur.w+1));
                visited[graph[cur.x]] = true;
            }
        }

        return 0;
    }

    static boolean range(int x){
        if(x>=1 && x<=300000) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[300001];
        visited = new boolean[300001];
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u] = v;
            graph[v] = u;
        }

        System.out.println(bfs(S, E));
    }
}
