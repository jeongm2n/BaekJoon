package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4485 {
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

    static void dijkstra(int N){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            return o1.w - o2.w;
        });

        visited[0][0] = true;
        q.offer(new Node(0, 0, graph[0][0]));
        dist[0][0] = graph[0][0];

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.x==N && n.y==N) return;
            
            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    if(!visited[ny][nx] && dist[ny][nx]>graph[ny][nx] + n.w){
                        dist[ny][nx] = graph[ny][nx] + n.w;
                        visited[ny][nx] = true;
                        q.offer(new Node(nx, ny, dist[ny][nx]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int N;

        while((N = Integer.parseInt(br.readLine()))!=0){
            graph = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];
            StringTokenizer st;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dist[i], 100001);
            }

            dijkstra(N);

            sb.append("Problem "+cnt+": "+dist[N-1][N-1]).append("\n");
            cnt++;
        }
        System.out.println(sb);
    }
}
