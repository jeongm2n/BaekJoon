package BFS;

import java.io.*;
import java.util.*;

public class Q19952 {
    static int T, H, W, O, F;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};

    static class Node{
        int x, y, hp;
        public Node(int x, int y, int hp){
            this.x = x;
            this.y = y;
            this.hp = hp;
        }
    }

    static String bfs(int sx, int sy, int ex, int ey){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, F));
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int hp = cur.hp;

            if(x==ex && y==ey) return "잘했어!!";
            if(hp<=0) break;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<1 || ny<1 || nx>H || ny>W || visited[nx][ny]) continue;
                if(hp <= graph[nx][ny]-graph[x][y]) continue;
                
                q.offer(new Node(nx, ny, hp-1));
                visited[nx][ny] = true;
            }
        }
        return "인성 문제있어??";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            int sx, sy, ex, ey;

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            graph = new int[H+1][W+1];
            visited = new boolean[H+1][W+1];

            for(int i=0; i<O; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                graph[x][y] = l;
            }

            sb.append(bfs(sx, sy, ex, ey)).append("\n");
        }

        System.out.println(sb);
    }
}
