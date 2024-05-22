package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10026 {
    static int n;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(int x, int y, char c){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x,y});

        while(!q.isEmpty()){
            int[] spot = q.poll();

            for(int i=0; i<4; i++){
                int nx = spot[0] + dx[i];
                int ny = spot[1] + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && graph[nx][ny]==c){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        graph = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            graph[i] = (br.readLine()).toCharArray();
        }

        int result1 = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(i, j, graph[i][j]);
                    result1++;
                }
            }
        }
        int result2 = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]=='G'){
                    graph[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(i, j, graph[i][j]);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);

    }
}
