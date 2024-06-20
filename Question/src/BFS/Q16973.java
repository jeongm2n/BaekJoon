package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16973 {
    static class Spot{
        int x, y, w;
        public Spot(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int N, M, w, h;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(int sx, int sy, int ex, int ey){
        Queue<Spot> q = new LinkedList<>();
        visited[sy][sx] = true;
        q.offer(new Spot(sx, sy, 0));

        int result = -1;

        while(!q.isEmpty()){
            Spot s = q.poll();

            if(s.x==ex && s.y==ey){
                result = s.w;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx>0 && ny>0 && nx<=M && ny<=N){
                    if(visited[ny][nx]) continue;
                    if(!range(nx, ny)) continue;
                    visited[ny][nx] = true;
                    q.offer(new Spot(nx, ny, s.w+1));
                }
            }
        }

        return result;
    }

    static boolean range(int x, int y){
        for(int i=y; i<y+h; i++){
            for(int j=x; j<x+w; j++){
                if(i>N || j>M || graph[i][j]==1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        int result = bfs(sx, sy, ex, ey);
        System.out.println(result==-1 ? -1 : result);
    }   
}
