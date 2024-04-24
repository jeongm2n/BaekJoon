package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2667 {
    static int[][] graph;
    static boolean[][] visited;
    static int cnt;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;

    static void dfs(int u, int v){
        visited[u][v] = true;
        cnt += 1;
        int nx = 0; int ny = 0;
        for(int i=0; i<4; i++){
            nx = dx[i] + u;
            ny = dy[i] + v;
            if((nx>=0&&nx<n&&ny>=0&&ny<n) && graph[nx][ny]==1 && !visited[nx][ny]) dfs(nx,ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        int result = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cnt = 0;
                if(graph[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    arr.add(cnt);
                    result++;
                }
            }
        }
        Collections.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        for(int i : arr){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
