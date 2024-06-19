package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14497 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int R, C;
    static int[][] graph;
    static int[][] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
    static final int INF = 1000001;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int dijkstra(int sx, int sy, int ex, int ey){
        pq.offer(new Node(sx, sy, 0));
        dist[sy][sx] = 0;
        int result = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int x = n.x;
            int y = n.y;

            if(x==ex && y==ey){
                result = n.w;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>0 && ny>0 && nx<=C && ny<=R){
                    if(dist[ny][nx] > dist[y][x] + graph[ny][nx]){
                        dist[ny][nx] = dist[y][x] + graph[ny][nx];
                        pq.offer(new Node(nx, ny, dist[ny][nx]));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R+1][C+1];
        dist = new int[R+1][C+1];
        for(int i=1; i<=R; i++) Arrays.fill(dist[i], INF);

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        for(int i=1; i<=R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                char c = s.charAt(j);
                if(c=='0' || c=='1') graph[i][j+1] = c-'0';
                else if(c=='#') graph[i][j+1] = 1;
            }
        }

        int result = dijkstra(sx, sy, ex, ey);
        System.out.println(result);
    }
}
