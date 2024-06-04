package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17086 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;          
        }
    }
    static int N, M;
    static int[][] graph;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new Node(x, y, 1));

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i=0; i<8; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(!visited[ny][nx]){
                        if(graph[ny][nx]==1) return n.w;

                        visited[ny][nx] = true;
                        q.offer(new Node(nx, ny, n.w+1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==0){
                    max = Math.max(max, bfs(j, i));
                }
            }
        }
        System.out.println(max);

    }
}
