package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14923 {
    static class Node{
        int x, y, w, use;
        public Node(int x, int y, int w, int use){
            this.x = x;
            this.y = y;
            this.w = w;
            this.use = use;
        }
    }
    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});

    static int bfs(int ex, int ey){
        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.x==ex&& n.y==ey) return n.w;

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>0 && ny>0 && nx<=M && ny<=N){
                    if(graph[ny][nx]==1 && n.use==0){
                        visited[ny][nx][1] = true;
                        pq.offer(new Node(nx, ny, n.w+1, 1));
                    }else if(graph[ny][nx]==0 && !visited[ny][nx][n.use]){
                        visited[ny][nx][n.use] = true;
                        pq.offer(new Node(nx, ny, n.w+1, n.use));
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

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        pq.offer(new Node(sx, sy, 0, 0));
        visited[sy][sx][0] = true;

        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(ex, ey);

        System.out.println(result==-1 ? -1 : result);
    }   
}
