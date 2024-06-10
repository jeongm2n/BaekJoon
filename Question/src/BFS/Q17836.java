package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17836 {
    static class Node{
        int x, y, w;
        boolean gram;
        public Node(int x, int y, int w, boolean gram){
            this.x = x;
            this.y = y;
            this.w = w;
            this.gram = gram;
        }
    }

    static int N, M, T;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][][] visited;

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.x==M-1 && n.y==N-1){
                if(n.w>T) break;
                return n.w;
            }

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(n.gram){
                        if(!visited[ny][nx][1])
                        q.offer(new Node(nx, ny, n.w+1, n.gram));
                        visited[ny][nx][1] = true;
                    }else{
                        if(!visited[ny][nx][0] &&graph[ny][nx]==0){
                            q.offer(new Node(nx, ny, n.w+1, n.gram));
                            visited[ny][nx][0] = true;
                        }else if(!visited[ny][nx][0] && graph[ny][nx]==2){
                            q.offer(new Node(nx, ny, n.w+1, true));
                            visited[ny][nx][0] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        System.out.println(result==-1 ? "Fail" : result);
    }
}
