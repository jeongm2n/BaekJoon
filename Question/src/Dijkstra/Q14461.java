package Dijkstra;

import java.io.*;
import java.util.*;

public class Q14461 {
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, T;

    static class Node{
        int x, y, m, w;
        public Node(int x, int y, int m, int w){
            this.x = x;
            this.y = y;
            this.m = m;
            this.w = w;
        }
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.w-o2.w;
        });

        pq.offer(new Node(0,0,0,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int m = cur.m;
            int w = cur.w;

            if(visited[y][x][m]) continue;
            visited[y][x][m] = true;

            if(x==N-1 && y==N-1){
                System.out.println(cur.w);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N || visited[ny][nx][(m+1)%3]) continue;
                if(m==2) pq.offer(new Node(nx, ny, 0, w + graph[ny][nx] + T));
                else pq.offer(new Node(nx, ny, m+1, w + T));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N][3]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstra();
    }
}
