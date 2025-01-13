package BFS;

import java.util.*;
import java.io.*;

public class Q30024 {
    static int N, M, graph[][], K;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o2.v-o1.v;});
    static StringBuilder sb = new StringBuilder();

    static class Answer{
        int x, y;
        public Answer(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Node{
        int x, y, v;
        public Node(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    static void bfs(){
        for(int i=0; i<K; i++){
            Node cur = pq.poll();
            sb.append(cur.y + " " + cur.x).append("\n");

            for(int j=0; j<4; j++){
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if(nx<=0 || nx>M || ny<=0 || ny>N || visited[ny][nx]) continue;
                pq.offer(new Node(nx, ny, graph[ny][nx]));
                visited[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                int corn = Integer.parseInt(st.nextToken());
                graph[i][j]=corn;

                if(i==1 || i==N){
                    pq.offer(new Node(j, i, graph[i][j]));
                    visited[i][j] = true;
                }else{
                    if(j==1 || j==M){
                        pq.offer(new Node(j, i, graph[i][j]));
                        visited[i][j] = true;
                    }
                }
            }
        }

        K = Integer.parseInt(br.readLine());

        bfs();

        System.out.println(sb);
    }
}
