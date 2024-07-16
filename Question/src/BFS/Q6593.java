package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6593 {
    static class Node{
        int z, x, y, time;
        public Node(int z, int x, int y, int time){
            this.z = z;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static char[][][] graph;
    static boolean[][][] visited;
    static int L, R, C;
    static Queue<Node> q = new LinkedList<>();

    static int bfs(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            int z = cur.z;
            int x = cur.x;
            int y = cur.y;

            if(graph[z][y][x]=='E') return cur.time;

            for(int i=0; i<6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(range(nz, nx, ny)){
                    if(!visited[nz][ny][nx] && graph[nz][ny][nx]!='#'){
                        visited[nz][ny][nx] = true;
                        q.offer(new Node(nz, nx, ny, cur.time+1));
                    }
                }
            }
        }
        return -1;
    }

    static boolean range(int z, int x, int y){
        if(z>=0 && x>=0 && y>=0 && z<L && x<C && y<R) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0) break;

            graph = new char[L][R][C];
            visited = new boolean[L][R][C];

            for(int z=0; z<L; z++){
                for(int i=0; i<R; i++){
                    String s = br.readLine();
                    for(int j=0; j<C; j++){
                        graph[z][i][j] = s.charAt(j);
                        if(graph[z][i][j]=='S') {
                            visited[z][i][j] = true;
                            q.offer(new Node(z, j, i, 0));
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs();

            sb.append(result==-1 ? "Trapped!" : "Escaped in " + result + " minute(s).").append("\n");
        }

        System.out.println(sb);
    }
}
