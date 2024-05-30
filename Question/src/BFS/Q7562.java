package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7562 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static int N;
    static Queue<Node> q;
    static int[] dx = {-2,-2,-1,-1,2,2,1,1};
    static int[] dy = {-1,1,-2,2,-1,1,-2,2};
    static boolean[][] visited;

    static int bfs(int x, int y){
        int cnt = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.x==x && n.y==y) {
                cnt = n.w;
                break;
            }

            for(int i=0; i<8; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.offer(new Node(nx, ny, n.w+1));
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(T!=0){
            T--;
            N = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            q.offer(new Node(sx, sy, 0));
            visited[sy][sx] = true;

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(bfs(x, y)).append("\n");
        }
        System.out.println(sb);
    }
}
