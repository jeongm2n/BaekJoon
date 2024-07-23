package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2194 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int N, M, A, B;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();

    static int bfs(int ex, int ey){
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==ex && cur.y==ey) return cur.w;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(range(nx, ny) && !visited[ny][nx]){
                    if(range2(nx, ny)){
                        q.offer(new Node(nx, ny, cur.w+1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }

    static boolean range2(int x, int y){
        for(int a=y; a<y+A; a++){
            for(int b=x; b<x+B; b++){
                if(!range(b, a)) return false;
                if(graph[a][b]==-1) return false;
            }
        }
        return true;
    }

    static boolean range(int x, int y){
        if(x>0 && y>0 && x<=M && y<=N) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = -1;
        }

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        q.offer(new Node(sx, sy, 0));
        visited[sy][sx] = true;

        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        System.out.println(bfs(ex, ey));

    }   
}
