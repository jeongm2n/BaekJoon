package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2589 {
    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int r, c;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static final int INF = 100001;

    static int bfs(int x, int y){
        visited = new boolean[r][c];
        dist = new int[r][c];
        Queue<Node> q = new LinkedList<>();
        int max = 0;

        for(int i=0; i<r; i++) Arrays.fill(dist[i], INF);

        visited[y][x] = true;
        dist[y][x] = 0;
        q.offer(new Node(x, y));

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && nx<c && ny>=0 && ny<r){
                    if(!visited[ny][nx] && graph[ny][nx]=='L' && dist[ny][nx]>dist[n.y][n.x] + 1){
                        dist[ny][nx] = dist[n.y][n.x] + 1;
                        q.offer(new Node(nx, ny));
                        max = Math.max(max, dist[ny][nx]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        
        for(int i=0; i<r; i++) graph[i] = (br.readLine()).toCharArray();    

        int max = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j]=='L'){
                    max = Math.max(max, bfs(j,i));
                }
            }
        }
        
        System.out.println(max);
    }
}
