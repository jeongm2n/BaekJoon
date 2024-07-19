package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21938 {
    static int[][] graph;
    static int N, M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<M && ny<N){
                if(!visited[ny][nx] && graph[ny][nx]==255){
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

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int sum = R+G+B;

                graph[i][j] = sum/3;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]>=T) graph[i][j] = 255;
                else graph[i][j] = 0;
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && graph[i][j]==255){
                    dfs(j, i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
