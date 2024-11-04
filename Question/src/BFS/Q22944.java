package BFS;

import java.io.*;
import java.util.*;

public class Q22944 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static int N, H, D, sx, sy, ex, ey;
    //빈칸 = 0, 우산 = 1;
    static int[][] visited; //우산 없을 때 0, 있을 때 1

    static class Node{
        int x, y, h, cost, w;

        public Node(int x, int y, int h, int cost, int w){
            this.x = x;
            this.y = y;
            this.h = h;
            this.cost = cost;
            this.w = w;
        }
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, H, 0, 0));
        visited[sy][sx] = H;

        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int h = cur.h;
                int cost = cur.cost;
                int w = cur.w;
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

                if(nx==ex && ny==ey){
                    min = Math.min(min, w+1);
                    continue;
                }

                if(graph[ny][nx]==1) cost = D;
                
                if(cost!=0) cost--;
                else h--;

                if(h==0) continue;

                if(visited[ny][nx] < h+cost){
                    visited[ny][nx] = h+cost;
                    q.offer(new Node(nx, ny, h, cost, w+1));
                }
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new int[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                char c = s.charAt(j);
                switch(c){
                    case 'S' : sx = j;
                                sy = i;
                                break;
                    case 'U' : graph[i][j] = 1;
                                break;
                    case 'E' : ex = j;
                                ey = i;
                                break;
                    default : graph[i][j] = 0;
                                break;
                }   
            }
        }

        int result = bfs();
        System.out.println(result==Integer.MAX_VALUE ? -1 : result);
    }
}
