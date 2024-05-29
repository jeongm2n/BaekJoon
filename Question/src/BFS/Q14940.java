package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14940 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int[][] graph;
    static int[][] dist;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int n;
    static int m;

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        dist[y][x] = 0;
        q.offer(new Node(x, y, 0));

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;

                if(!visited[ny][nx] && graph[ny][nx]==1){
                    dist[ny][nx] = node.w+1;
                    visited[ny][nx] = true;
                    q.offer(new Node(nx, ny, dist[ny][nx]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) Arrays.fill(dist[i], -1);
        int x = 0;
        int y = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                if(a==2){
                    x = j;
                    y = i;
                }
                if(a==0) dist[i][j] = 0;
            }
        }
        bfs(x, y);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
