package BFS;

import java.io.*;
import java.util.*;

public class Q23352 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int N, M, s;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int result = 0;

    static void bfs(int sx, int sy){
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(sx, sy, 0));
        int route = 0;

        while(!q.isEmpty()){       
            Node Node = q.remove();
            int x = Node.x;
            int y = Node.y;
            int w = Node.w;
            int end = graph[y][x];
            
            if(w >= route){
                if(w > route){
                    result = s + end;
                }else{
                    result = Math.max(result, s+end);
                }
                route = w;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(visited[ny][nx] || graph[ny][nx]==0) continue;
                visited[ny][nx] = true;
                
                q.add(new Node(nx, ny, w+1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j] != 0){
                    visited = new boolean[N][M];
                    visited[i][j] = true;
                    s = graph[i][j];
                    bfs(j, i);
                }
            }
        }

        System.out.println(result);
    }
}
