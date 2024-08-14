package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13700 {
    static class Node{
        int x, w;
        public Node(int x, int w){
            this.x = x;
            this.w = w;
        }
    }
    static int[] graph;
    static int N, F, B, D;
    static boolean[] visited;

    static int bfs(int S){
        Queue<Node> q = new LinkedList<>();
        visited[S] = true;
        q.offer(new Node(S, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==D) return cur.w;

            int nx = cur.x + F;
            if(range(nx) && !visited[nx] && graph[nx]!=1){
                q.offer(new Node(nx, cur.w+1));
                visited[nx] = true;
            }

            nx = cur.x - B;
            if(range(nx) && !visited[nx] && graph[nx]!=1){
                q.offer(new Node(nx, cur.w+1));
                visited[nx] = true;
            }
        }
        return -1;
    }

    static boolean range(int x){
        if(x<=0 || x>N) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[N+1];
        visited = new boolean[N+1];

        if(K!=0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                graph[Integer.parseInt(st.nextToken())] = 1;
            }
        }

        int result = bfs(S);
        System.out.println(result!=-1 ? result : "BUG FOUND");

    }
}
