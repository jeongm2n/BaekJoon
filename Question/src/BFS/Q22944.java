package BFS;

import java.io.*;
import java.util.*;

public class Q22944 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static int N, H, D, sx, sy, ex, ey;
    //빈칸 = 0, 우산 = 1;
    static boolean[][][] visited; //우산 없을 때 0, 있을 때 1

    static class Node{
        int x, y, h, u, d, w;

        public Node(int x, int y, int h, int u, int d, int w){
            this.x = x;
            this.y = y;
            this.h = h;
            this.u = u;
            this.d = d;
            this.w = w;
        }
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, H, 0, 0, 0));
        visited[sy][sx][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int h = cur.h;
            int d = cur.d;
            int u = cur.u;
            int w = cur.w;

            if(cur.x==ex && cur.y==ey) return w;

            for(int i=0; i<4; i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if(nx<0 || ny<0 || nx>=N || ny>=N || visited[ny][nx][u]) continue;
                if(h==0) return -1;

                if(u==0){
                    if(graph[ny][nx]==0){
                        q.offer(new Node(nx, ny, h-1, 0, 0, w+1));
                        visited[ny][nx][0] = true;
                    }else{
                        q.offer(new Node(nx, ny, h, 1, D, w+1));
                        visited[ny][nx][1] = true;
                    }
                }else{
                    if(graph[ny][nx]==0){
                        if(d-1==0){
                            q.offer(new Node(nx, ny, h, 0, 0, w+1));
                            visited[ny][nx][0] = true;
                        }else{
                            q.offer(new Node(nx, ny, h, 1, d-1, w+1));
                            visited[ny][nx][1] = true;
                        }
                    }else{
                        q.offer(new Node(nx, ny, h, 1, D, w+1));
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N][2];

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

        System.out.println(bfs());
    }
}
