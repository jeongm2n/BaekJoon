package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1189 {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int R, C, K;
    static int result;

    static void dfs(int x, int y, int cnt){
        if(x==C-1 && y==0){
            if(cnt==K) result++;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<C && ny>=0 && ny<R){
                if(!visited[ny][nx] && graph[ny][nx]!='T'){
                    visited[ny][nx] = true;
                    dfs(nx, ny, cnt+1);
                    visited[ny][nx] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            graph[i] = br.readLine().toCharArray();
        }

        result = 0;
        visited[R-1][0] = true;
        dfs(0, R-1, 1);
        System.out.println(result);
    }   
}
