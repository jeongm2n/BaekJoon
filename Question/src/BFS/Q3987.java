package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3987 {
    static class Node{
        int x, y, w, d;
        public Node(int x, int y, int w, int d){
            this.x = x;
            this.y = y;
            this.w = w;
            this.d = d;
        }
    }

    static int N, M;
    static char[][] graph;
    static char[] dir = {'U', 'R', 'D', 'L'}; //순서대로 상우하좌

    static int bfs(int sx, int sy, int sd){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, 1, sd));

        while(true){
            Node cur = q.poll();
            
            if(cur.w>250000) break;

            int nx=cur.x, ny=cur.y;

            if(cur.d==1) ny--;
            if(cur.d==2) nx++;
            if(cur.d==3) ny++;
            if(cur.d==4) nx--;

            if(nx<0 || ny<0 || nx>=M || ny>=N || graph[ny][nx]=='C') return cur.w;
            
            if(graph[ny][nx]!='.'){
                q.offer(new Node(nx, ny, cur.w+1, changeDir(graph[ny][nx], cur.d)));
                continue;
            }
            q.offer(new Node(nx, ny, cur.w+1, cur.d));
        }
        return -1;
    }

    static int changeDir(char c, int d){
        int nd = 0;
        switch(c){
            case '\\' :
                if(d==1) nd=4;
                if(d==2) nd=3;
                if(d==3) nd=2;
                if(d==4) nd=1;
                break;
            case '/' :
                if(d==1) nd=2;
                if(d==2) nd=1;
                if(d==3) nd=4;
                if(d==4) nd=3;
                break;
        }
        return nd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            graph[i] = s.toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        boolean turn = false;
        int max = 0;
        int min = 5;
        for(int i=1; i<=4; i++){
            int result = bfs(sx-1, sy-1, i);
            if(result==-1){
                turn = true;
                break;
            }else{
                min = Math.min(i, min);
                max = Math.max(max, result);
            }
        }

        sb.append(dir[min-1]).append("\n");
        if(turn) sb.append("Voyager");
        else sb.append(max);

        System.out.println(sb);
    }
}
