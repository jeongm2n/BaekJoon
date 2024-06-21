package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16174 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==N-1 && cur.y==N-1){
                System.out.println("HaruHaru");
                System.exit(0);
            }

            for(int i=0; i<2; i++){
                int nx = cur.x + dx[i]*graph[cur.y][cur.x];
                int ny = cur.y + dy[i]*graph[cur.y][cur.x];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[ny][nx]){
                    q.offer(new Node(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println("Hing");
    }   
}