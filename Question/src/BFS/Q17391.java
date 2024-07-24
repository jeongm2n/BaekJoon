package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17391 {
    static class Cart{
        int x, y, b, t;
        public Cart(int x, int y, int b, int t){
            this.x = x;
            this.y = y;
            this.b = b;
            this.t = t;
        }
    }
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static int bfs(){
        Queue<Cart> q = new LinkedList<>();
        q.offer(new Cart(0, 0, graph[0][0], 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Cart cur = q.poll();

            if(cur.x==M-1 && cur.y==N-1) return cur.t;
            for(int i=0; i<2; i++){
                for(int j=1; j<=cur.b; j++){
                    int nx = cur.x + dx[i]*j;
                    int ny = cur.y + dy[i]*j;

                    if(nx>=M) nx=M-1;
                    if(ny>=N) ny=N-1;

                    if(!visited[ny][nx]){
                        q.offer(new Cart(nx, ny, graph[ny][nx], cur.t+1));
                        visited[ny][nx] = true;
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
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
}
