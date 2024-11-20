package BFS;

import java.io.*;
import java.util.*;

public class Q31575 {
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        visited[0][0] = true;
        int result = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0]==N-1 && cur[1]==M-1){
                result = cur[2];
                break;
            }

            for(int i=0; i<2; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[ny][nx]) continue;
                if(graph[ny][nx]==0) continue;

                q.offer(new int[]{nx, ny, cur[2]+1});
                visited[ny][nx] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = bfs();

        System.out.println(answer==-1 ? "No" : "Yes");
    }
}
