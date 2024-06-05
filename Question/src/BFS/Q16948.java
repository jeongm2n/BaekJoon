package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16948 {
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    static int N;

    static int bfs(int r1, int c1, int r2, int c2){
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1, 0});
        visited[c1][r1] = true;
        int cnt = -1;

        while(!q.isEmpty()){
            int[] data = q.poll();

            if(data[0]==r2 && data[1]==c2){
                cnt=data[2];
                break;
            }

            for(int i=0; i<6; i++){
                int nx = data[0] + dx[i];
                int ny = data[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.offer(new int[] {nx, ny, data[2]+1});
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int result = bfs(r1, c1, r2, c2);
        System.out.println(result);
    }
}
