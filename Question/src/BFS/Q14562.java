package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14562 {
    static class Point{
        int p, t, w;
        public Point(int p, int t, int w){
            this.p = p;
            this.t = t;
            this.w = w;
        }
    }

    static int bfs(int S, int T){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(S, T, 0));

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.p==cur.t) return cur.w;

            for(int i=0; i<2; i++){
                int np=0, nt=0;
                if(i==0){
                    np = cur.p*2;
                    nt = cur.t + 3;
                }else{
                    np = cur.p+1;
                    nt = cur.t;
                }
                if(np>nt) continue;
                q.offer(new Point(np, nt, cur.w+1));
                
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            int result = bfs(S, T);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
