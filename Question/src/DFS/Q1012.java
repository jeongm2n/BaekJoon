package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int w, h;

    static void dfs(int y, int x){
        visited[y][x] = true;
        int nx = 0; int ny = 0;
        for(int i=0; i<4; i++){
            nx = dx[i] + x;
            ny = dy[i] + y;
            if((nx>=0&&nx<w&&ny>=0&&ny<h) && graph[ny][nx]==1 && !visited[ny][nx]) dfs(ny,nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int z=0; z<t; z++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new int[h][w];
            visited = new boolean[h][w];

            for(int y=0; y<k; y++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[v][u] = 1;
            }
            int result = 0;

            for(int i=0; i<h; i++){
                for (int j=0; j<w; j++){
                    if(graph[i][j]==1 && !visited[i][j]){
                        dfs(i,j);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
