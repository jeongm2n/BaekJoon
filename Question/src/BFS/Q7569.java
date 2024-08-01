package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7569 {
    static class Spot{
        int x, y, z, t;
        public Spot(int x, int y, int z, int t){
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }
    }
    static int M, N, H, T=0;
    static int[][][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static Queue<Spot> q = new LinkedList<>();

    static int bfs(){
        int max = 0;

        while(!q.isEmpty()){
            Spot cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int z = cur.z;
            visited[z][y][x] = true;
            max = Math.max(max, cur.t);

            for(int i=0; i<6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(range(nx, ny, nz) && !visited[nz][ny][nx] && graph[nz][ny][nx]==0){
                    q.offer(new Spot(nx, ny, nz, cur.t+1));
                    graph[nz][ny][nx]=1;
                }
            }
        }

        return max;
    } 

    static boolean range(int nx, int ny, int nz){
        if(nz>=0 && nx>=0 && ny>=0 && nz<H && nx<N && ny<M) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][M][N];
        visited = new boolean[H][M][N];

        for(int z=0; z<H; z++){
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    graph[z][i][j] = Integer.parseInt(st.nextToken());
                    if(graph[z][i][j]==1) q.offer(new Spot(j, i, z, 0));
                }
            }
        }

        int result = bfs();

        for(int z=0; z<H; z++){
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(graph[z][i][j]==0){
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
