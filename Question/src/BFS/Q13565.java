package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13565 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int M, N;
    static int[][] graph;
    static boolean[][] visited; 
    static boolean result = false;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.y==M-1){
                result = true;
                return;
            }

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(!visited[ny][nx] && graph[ny][nx]==0){
                        q.offer(new Node(nx, ny));
                        visited[ny][nx]=true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            if(graph[0][i]==0 && !visited[0][i]) bfs(i, 0);
        }

        System.out.println(result ? "YES" : "NO");
    }
}
