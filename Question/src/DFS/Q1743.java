package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1743 {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int cnt;

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=1 && ny>=1 && nx<=M && ny<=N){
                if(!visited[ny][nx] && graph[ny][nx]=='#'){
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new char[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(graph[i], '.');
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            graph[y][x] = '#';
        }

        int result = 0;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!visited[i][j] && graph[i][j]=='#'){
                    cnt = 1;
                    dfs(j, i);
                    result = Math.max(cnt, result);
                }
            }
        }

        System.out.println(result);
    }
}
