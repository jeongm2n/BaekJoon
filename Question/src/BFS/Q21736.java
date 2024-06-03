package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21736 {
    static Queue<int[]> q;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, M;

    static int bfs(){
        int cnt = 0;

        while(!q.isEmpty()){
            int[] data = q.poll();

            for(int i=0; i<4; i++){
                int nx = data[0] + dx[i];
                int ny = data[1] + dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N && graph[ny][nx]!='X' && !visited[ny][nx]){
                    if(graph[ny][nx]=='P') cnt++;
                    q.offer(new int[] {nx, ny});
                    visited[ny][nx] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = str.charAt(j);
                if(graph[i][j]=='I'){
                    q.offer(new int[] {j, i});
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs();

        System.out.println(result==0 ? "TT" : result);
    }
}
