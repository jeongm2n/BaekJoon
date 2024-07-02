package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10711 {
    static int R, C;
    static int[][] graph;

    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};
    static Queue<int[]> q = new LinkedList<>();

    static int bfs(){
        int cnt = -1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();

                for(int j=0; j<8; j++){
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx>=0 && ny>=0 && nx<C && ny<R){
                        if(graph[ny][nx]>=1 && graph[ny][nx]<9){
                            graph[ny][nx]--;
                            if(graph[ny][nx]==0) q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                char c = s.charAt(j);
                if(c=='.') {
                    graph[i][j] = 0;
                    q.offer(new int[] {j, i});
                }
                else graph[i][j] = c-'0';
            }
        }

        System.out.println(bfs());

    }   
}
