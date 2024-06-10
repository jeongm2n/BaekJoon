package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19238 {
    static int N, M, F;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dist; 

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static PriorityQueue<Person> pq = new PriorityQueue<>((o1,o2)->{
        if(o1.w==o2.w){
            if(o1.sy==o2.sy){
                return o1.sx - o2.sx;
            }
            return o1.sy - o2.sy;
        }
        return o1.w - o2.w;
    });

    static class Person{
        int sx, sy, ex, ey, w;
        public Person(int sx, int sy, int ex, int ey, int w){
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
            this.w = w;
        }
    }

    static void getDist(int x, int y){
        visited = new boolean[N+1][N+1];
        dist = new int[N+1][N+1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[y][x] = true;
        dist[y][x] = 0;

        while(!q.isEmpty()){
            int[] spot = q.poll();

            for(int i=0; i<4; i++){
                int nx = spot[0] + dx[i];
                int ny = spot[1] + dy[i];

                if(nx>=1 && ny>=1 && nx<=N && ny<=N && !visited[ny][nx] && graph[ny][nx]!=1){
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[spot[1]][spot[0]]+1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> q;
        visited = new boolean[N+1][N+1];

        while(!pq.isEmpty()){
            q = new LinkedList<>();
            Person p = pq.poll();
            q.offer(new int[] {p.sx, p.sy, p.w});
            int f = p.w;

            while(!q.isEmpty()){
                int[] spot = q.poll();

                if(spot[0]==p.ex && spot[1]==p.ey){
                    f += spot[2];
                    if(f>F){
                        F = -1;
                        return;
                    }
                    F = F-f + (f*2);
                    getDist(spot[0], spot[1]);
                    for(int i=0; i<pq.size(); i++){
                        Person t = pq.poll();
                        pq.offer(new Person(t.sx, t.sy, t.ex, t.ey, dist[t.sy][t.sx]));
                    }
                }

                for(int i=0; i<4; i++){
                    int nx = spot[0] + dx[i];
                    int ny = spot[1] + dy[i];

                    if(nx>=1 && ny>=1 && nx<=N && ny<=N && !visited[ny][nx] && graph[ny][nx]!=1){
                        visited[ny][nx] = true;
                        q.offer(new int[] {nx, ny, spot[2]+1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        getDist(e, s);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            pq.offer(new Person(sx, sy, ex, ey, dist[sy][sx]));
        }

        bfs(e, s);

        System.out.println(F);
    }   
}
