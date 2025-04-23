package BFS;

import java.io.*;
import java.util.*;

public class Q18405 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, K, S, X, Y;
    static int[][] graph;
    static Queue<Node>[] que;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(){
        while(S-->0){
            for(int z=1; z<=K; z++){
                int qs = que[z].size();

                for(int j=0; j<qs; j++){
                    Node cur = que[z].poll();

                    for(int i=0; i<4; i++){
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if(nx<=0 || nx>N || ny<=0 || ny>N) continue;
                        if(graph[ny][nx]==0){
                            que[z].offer(new Node(nx, ny));
                            graph[ny][nx] = z;
                        }
                    }
                }
            }
        }
        
        System.out.println(graph[X][Y]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        que = new LinkedList[K+1];
        for(int i=1; i<=K; i++) que[i] = new LinkedList<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]!=0) que[graph[i][j]].offer(new Node(j, i));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs();
    }
}
