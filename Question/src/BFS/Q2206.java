package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2206 {
    static class Node{
        int x, y, w;
        boolean broken;
        public Node(int x, int y, int w, boolean broken){
            this.x = x;
            this.y = y;
            this.w = w;
            this.broken = broken;
        }
    }

    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new Node(0,0,1,false));

        int result = -1;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==M-1 && cur.y==N-1){
                result = cur.w;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(graph[ny][nx]==0){
                        if(!cur.broken && !visited[ny][nx][0]){
                            visited[ny][nx][0] = true;
                            q.offer(new Node(nx, ny, cur.w+1, cur.broken));
                        }else if(cur.broken && !visited[ny][nx][1]){
                            visited[ny][nx][1] = true;
                            q.offer(new Node(nx, ny, cur.w+1, cur.broken));
                        }
                    }
                    if(graph[ny][nx]==1){
                        if(!cur.broken && !visited[ny][nx][0]){
                            visited[ny][nx][0] = true;
                            q.offer(new Node(nx, ny, cur.w+1, true));
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = s.charAt(j)-'0';
            }
        }

        System.out.println(bfs());
    }
}
