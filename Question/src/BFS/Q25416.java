package BFS;

import java.io.*;
import java.util.*;

public class Q25416 {
    static int[][] graph = new int[5][5];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited = new boolean[5][5];

    static int bfs(int c, int r){
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[] {c, r, 0});

        int result = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(graph[cur[1]][cur[0]]==1){
                result = cur[2];
                break;
            }

            for(int i=0; i<4; i++){
                int nc = cur[0] + dx[i];
                int nr = cur[1] + dy[i];

                if(nc<0 || nc>4 || nr<0 || nr>4) continue;
                if(visited[nr][nc] || graph[nr][nc]==-1) continue;

                q.offer(new int[] {nc, nr, cur[2]+1});
                visited[nr][nc] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(bfs(c,r));
    }
}
