package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14716 {
    static int[][] graph;
    static boolean[][] visited;
    static int M, N;

    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,1,-1,-1,1};

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(!visited[ny][nx] && graph[ny][nx]==1){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && graph[i][j]==1){
                    dfs(j, i);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
