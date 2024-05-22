package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7576 {
    static class Tomato{
        int x;
        int y;
        int day;
        public Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int n, m;

    static Queue<Tomato> q = new LinkedList<>();

    static int bfs(int[][] box){
        int day = 0;

        while(!q.isEmpty()){
            Tomato t = q.poll();
            day = t.day;

            for(int i=0; i<4; i++){
                int nx = t.x + dx[i];
                int ny = t.y + dy[i]; 

                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    if(box[ny][nx]==0){
                        box[ny][nx] = 1;
                        q.offer(new Tomato(nx, ny, t.day+1));
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(box[i][j]==0) {
                    return -1;
                }
            }
        }

        return day;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1) q.offer(new Tomato(j, i, 0));
            }
        }
        
        int result = bfs(box);
        System.out.println(result);
    }   
}
