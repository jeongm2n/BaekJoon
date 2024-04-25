package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    static class spot{
        int x;
        int y;

        spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] graph;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1}; //좌우
    static int[] dy = {-1,1,0,0}; //상하
    static int w;
    static int h;

    static void bfs(int x, int y){
        visited[0][0] = true;
        Queue<spot> q = new LinkedList<>();
        q.offer(new spot(x,y));

        while(!q.isEmpty()){
            spot s = q.poll();
            for(int i=0; i<4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];
                
                if(nx<0||nx>=w||ny<0||ny>=h) continue;
                if(graph[ny][nx]==0 || visited[ny][nx]) continue;
                q.offer(new spot(nx,ny));
                graph[ny][nx] = graph[s.y][s.x]+1;
                visited[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        graph = new int[h][w];
        visited = new boolean[h][w];

        for(int i=0; i<h; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(graph[h-1][w-1]);
    }
}
