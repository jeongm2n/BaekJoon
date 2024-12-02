package BFS;

import java.io.*;
import java.util.*;

public class Q18235 {
    static class Spot{
        int x, day;
        public Spot(int x, int day){
            this.x = x;
            this.day = day;
        }
    }

    static int N, A, B;
    static int[] visited;
    static int[] dx = {1,-1};

    static int bfs(){
        Queue<Spot> q = new LinkedList<>();

        q.offer(new Spot(A, 0));
        q.offer(new Spot(B, 0));

        while(!q.isEmpty()){
            Spot cur = q.poll();
            int x = cur.x;
            int day = cur.day;

            for(int i=0; i<2; i++){
                int nx = x + (dx[i] * (int)Math.pow(2, day));

                if(nx>0 && nx<=N){
                    if(visited[nx] == day+1) return day+1;
                    visited[nx] = day+1;
                    q.offer(new Spot(nx, day+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        visited = new int[N+1];

        System.out.println(bfs());
    }
}
