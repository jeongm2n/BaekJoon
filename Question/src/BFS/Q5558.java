package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5558 {
    static class Rat{
        int x, y, hp, time;
        public Rat(int x, int y, int hp, int time){
            this.x = x;
            this.y = y;
            this.hp = hp;
            this.time = time;
        }
    }

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(int sx, int sy, int H, int W, int N){
        Queue<Rat> q = new LinkedList<>();
        q.offer(new Rat(sx, sy, 1, 0));
        visited[sy][sx] = true;

        while(!q.isEmpty()){
            Rat cur = q.poll();

            if(N==0) return cur.time;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && ny>=0 && nx<W && ny<H){
                    if(graph[ny][nx]>0 && graph[ny][nx]<=cur.hp){
                        graph[ny][nx] = 0;
                        q.clear();
                        q.offer(new Rat(nx, ny, cur.hp+1, cur.time+1));
                        visited = new boolean[H][W];
                        N--;
                        break;
                    }else if(graph[ny][nx]>=0 && !visited[ny][nx]){
                        q.offer(new Rat(nx, ny, cur.hp, cur.time+1));
                        visited[ny][nx] = true;
                    }                    
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        graph = new int[H][W];
        visited = new boolean[H][W];
        int sx = 0, sy = 0;
        for(int i=0; i<H; i++){
            String s = br.readLine();
            for(int j=0; j<W; j++){
                char c = s.charAt(j);
                if(c=='.') graph[i][j] = 0;
                else if(c=='X') graph[i][j] = -1;
                else if(c=='S'){
                    graph[i][j] = 0;
                    sx = j;
                    sy = i;
                }
                else graph[i][j] = Integer.parseInt(String.valueOf(c));
            }
        }

        System.out.println(bfs(sx, sy, H, W, N));
    }   
}
