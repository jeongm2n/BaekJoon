package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21922 {
    static class Node{
        int x, y, w, dir;
        public Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int[][] graph;
    static int N, M;
    static boolean[][] visited;

    static int bfs(int sx, int sy, int d){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, d));
        int cnt = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            
            int x = cur.x, y = cur.y, dir = cur.dir;
            if(!visited[y][x]) cnt++; 
            visited[y][x] = true;

            if(graph[y][x]==1 && (dir==2 || dir==3)) break;
            if(graph[y][x]==2 && (dir==0 || dir==1)) break;
            
            if(graph[y][x]==3){
                if(dir==0) dir=2;
                if(dir==2) dir=1;
                if(dir==1) dir=2;
                if(dir==3) dir=0;
            }
            else if(graph[y][x]==4){
                if(dir==0) dir=2;
                if(dir==1) dir=3;
                if(dir==2) dir=0;
                if(dir==3) dir=1;  
            }
            
            int nx=0, ny=0;
            if(dir==0) ny = y+1;
            if(dir==1) ny = y+1;
            if(dir==2) nx = x-1;
            if(dir==3) nx = x+1;

            if(nx<0 || ny<0 || nx>=M || ny>=N) break;

            q.offer(new Node(nx, ny, dir));
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];
        int sx=0, sy=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==9){
                    sx = j;
                    sy = i;
                }
            }
        }

        int sum=0;

        for(int i=0; i<4; i++) sum += bfs(sx, sy, i);

        System.out.println(sum);
    }
}
