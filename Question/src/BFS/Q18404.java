package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18404 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int[][] graph;
    static int n, kx, ky;
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static boolean[][] visited;

    static void bfs(){
        visited = new boolean[n+1][n+1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(kx, ky, 0));
        visited[ky][kx] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>0 && ny>0 && nx<=n && ny<=n){
                    if(!visited[ny][nx]){
                        q.offer(new Node(nx, ny, cur.w+1));
                        graph[ny][nx] = cur.w+1;
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        ky = Integer.parseInt(st.nextToken());
        kx = Integer.parseInt(st.nextToken());

        bfs();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            sb.append(graph[ey][ex]).append(" ");
        }

        System.out.println(sb);
    }
}
