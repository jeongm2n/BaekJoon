package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1600 {
    static class Node{
        int x, y, w, k;
        public Node(int x, int y, int w, int k){
            this.x = x;
            this.y = y;
            this.w = w;
            this.k = k;
        }
    }

    static int K, W, H;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] hx = {-2,-2,-1,-1,1,1,2,2};
    static int[] hy = {-1,1,-2,2,-2,2,-1,1};

    static int bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        q.offer(new Node(0,0,0,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int w = cur.w;
            int k = cur.k;

            if(x==W-1 && y==H-1) return w;

            int nx, ny;

            for(int i=0; i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(range(nx, ny)){
                    if(!visited[ny][nx][k] && graph[ny][nx]==0){
                        visited[ny][nx][k] = true;
                        q.offer(new Node(nx, ny, w+1, k));
                    }
                }
            }

            if(k>=K) continue;
            for(int i=0; i<8; i++){
                nx = x + hx[i];
                ny = y + hy[i];

                if(range(nx, ny)){
                    if(!visited[ny][nx][k+1] && graph[ny][nx]==0){
                        visited[ny][nx][k+1] = true;
                        q.offer(new Node(nx, ny, w+1, k+1));
                    }
                }
            }
        }

        return -1;
    }

    static boolean range(int x, int y){
        if(x>=0 && y>=0 && x<W && y<H) return true;
        return false;
    }  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
}
