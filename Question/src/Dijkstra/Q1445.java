package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1445 {
    static class Node{
        int x, y, g, w;
        public Node(int x, int y, int g, int w){
            this.x = x;
            this.y = y;
            this.g = g;
            this.w = w;
        }
    }

    static class Blank{
        int x, y;
        public Blank(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
        if(o1.g==o2.g) return o1.w-o2.w;
        return o1.g-o2.g;
    });
    static ArrayList<Blank> list = new ArrayList<>();
    static int resultg, resultw;

    static void makeB(){
        for(Blank b : list){
            for(int i=0; i<4; i++){
                int nx = b.x + dx[i];
                int ny = b.y + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(graph[ny][nx]=='.') graph[ny][nx] = 'b';
                }
            }
        }
    }

    static void dijkstra(){
        resultg = 0;
        resultw = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                int g = cur.g;
                int w = cur.w;
                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(!visited[ny][nx]){
                        if(graph[ny][nx]=='F'){
                            resultg = g;
                            resultw = w;
                            return;
                        }
                        else if(graph[ny][nx]=='g') g++;
                        else if(graph[ny][nx]=='b') w++;

                        pq.offer(new Node(nx, ny, g, w));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j]=s.charAt(j);
                if(graph[i][j]=='S') {
                    pq.offer(new Node(j, i, 0, 0));
                    visited[i][j] = true;
                }
                else if(graph[i][j]=='g') list.add(new Blank(j, i));
            }
        }

        makeB();
        dijkstra();
        System.out.println(resultg + " " + resultw);
    }
}
