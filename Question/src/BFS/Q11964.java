package BFS;

import java.io.*;
import java.util.*;

public class Q11964 {
    static int T, A, B;
    static boolean[][] visited;
    
    static class Stat{
        int w, water;
        public Stat(int w, int water){
            this.w = w;
            this.water = water;
        }
    }

    static int bfs(){
        Queue<Stat> q = new LinkedList<>();
        q.offer(new Stat(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Stat cur = q.poll();

            int w = cur.w;
            int water = cur.water;

            if(w+A<=T && !visited[w][water]){
                q.offer(new Stat(w+A, water));
                visited[w+A][water] = true;
            }
            if(w+B<=T && !visited[w][water]){
                q.offer(new Stat(w+B, water));
                visited[w+B][water] = true;
            } 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        visited = new boolean[5000001][2];

    }
}
