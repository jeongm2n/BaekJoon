package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2665 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] graph, dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static final int INF = Integer.MAX_VALUE;

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        dist[0][0] = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && dist[ny][nx]>dist[cur.y][cur.x]){
                    if(graph[ny][nx]==0) dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    else dist[ny][nx] = dist[cur.y][cur.x];
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dist = new int[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for(int i=0; i<N; i++) Arrays.fill(dist[i], INF);

        bfs();
        System.out.println(dist[N-1][N-1]);
    }
}
