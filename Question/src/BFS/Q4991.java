package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4991 {
    static class Node{
        int x, y, w;
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static int[][] graph;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static final int INF = 1000001;
    static int dirty = 0;

    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited = new boolean[h][w];
        visited[y][x] = true;
        int dist = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && ny>=0 && nx<w && ny<h){
                    if(!visited[ny][nx] && graph[ny][nx]!=-1){
                        visited[ny][nx] = true;
                        q.offer(new Node(nx, ny, n.w+1));

                        if(graph[ny][nx]==INF) {
                            dist += n.w+1;
                            dirty--;
                            if(dirty==0) return dist;
                            //visited = new boolean[h][w];
                        }
                        graph[ny][nx] = n.w+1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new int[h][w];
            if(w==0 && h==0) break;

            int x = 0; int y = 0;
            for(int i=0; i<h; i++){
                String s = br.readLine();
                for(int j=0; j<w; j++){
                    char c = s.charAt(j);
                    switch(c){
                        case 'x' : graph[i][j] = -1;
                            break;
                        case '*' : graph[i][j] = INF;
                            dirty++;
                            break;
                        case 'o' : x=j; y=i;
                    }
                }
            }

            int result = bfs(x, y);

            System.out.println(result==-1 ? -1 : result);
        }
    }
}
