package BFS;

import java.io.*;
import java.util.*;

public class Q20926 {
    static int W, H;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static boolean[][] visited;

    static class Node{
        int x, y, w, dir; //dir -> 0 = 상, 1 = 하, 2 = 좌, 3 = 우, -1 = 미끄러지지 않았을 때
        public Node(int x, int y, int w, int dir){
            this.x = x;
            this.y = y;
            this.w = w;
            this.dir = dir;
        }
    }

    static int bfs(int sx, int sy){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.w - o2.w;});
        visited[sy][sx] = true;
        q.offer(new Node(sx, sy, 0, -1));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int w = cur.w;
            int dir = cur.dir;

            if(dir==-1){
                for(int i=0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx<0 || ny<0 || nx>=W || ny>=H || visited[ny][nx] || graph[ny][nx]==-1 || graph[ny][nx]==-2) continue;
                    if(graph[ny][nx]==0) return w;

                    q.offer(new Node(nx, ny, w+graph[ny][nx], i));
                    visited[ny][nx] = true;
                }
            }else{
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx<0 || ny<0 || nx>=W || ny>=H || visited[ny][nx] || graph[ny][nx]==-1) continue;
                if(graph[ny][nx]==0) return w;

                if(graph[ny][nx] == -2) q.offer(new Node(x, y, w, -1));
                else{
                    q.offer(new Node(nx, ny, w+graph[ny][nx], dir));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][W];
        visited = new boolean[H][W];
        int sx=0, sy=0;

        for(int i=0; i<H; i++){
            String s = br.readLine();
            for(int j=0; j<W; j++){
                char c = s.charAt(j);
                if(c=='E') graph[i][j] = 0;
                else if(c=='R') graph[i][j] = -2;
                else if(c=='H') graph[i][j] = -1;
                else if(c=='T'){
                    sx = j;
                    sy = i;
                }else graph[i][j] = c-'0';
            }
        }

        System.out.println(bfs(sx, sy));
    }
}
