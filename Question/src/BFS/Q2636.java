package BFS;

import java.util.*;
import java.io.*;

public class Q2636 {
    static int N, M, cnt=0, time=0, graph[][];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=M || ny>=N || visited[ny][nx]) continue;
                visited[ny][nx] = true;

                if(graph[ny][nx]==0){
                    q.offer(new int[]{nx, ny});
                }else{
                    graph[ny][nx] = 0;
                    cnt--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        graph = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==1) cnt++;
            }
        }

        int cheese = 0;

        while(cnt!=0){
            cheese = cnt;
            bfs();
            time++;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(time + "\n" + cheese);

        System.out.println(sb);
    }
}
