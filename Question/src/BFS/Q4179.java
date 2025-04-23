package BFS;

import java.io.*;
import java.util.*;

public class Q4179 {
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static char[][] graph;
    static int R, C;
    static Queue<Node> jq = new LinkedList<>();
    static Queue<Node> fq = new LinkedList<>();

    static void bfs(){
        int result = 0;

        while(true){
            result++;
            int fqs = fq.size();
            for(int j=0; j<fqs; j++){
                Node cur = fq.poll();
                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || nx>=C || ny<0 || ny>=R) continue;
                    if(graph[ny][nx]=='.' || graph[ny][nx]=='J') {
                        fq.offer(new Node(nx, ny));
                        graph[ny][nx]='F';
                    }
                }
            }

            int jqs = jq.size();
            for(int j=0; j<jqs; j++){
                Node cur = jq.poll();
                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || nx>=C || ny<0 || ny>=R){
                        System.out.println(result);
                        return;
                    }
                    if(graph[ny][nx]=='.') {
                        jq.offer(new Node(nx, ny));
                        graph[ny][nx]='J';
                    }
                }
            }

            if(jq.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();

            for(int j=0; j<C; j++){
                graph[i][j] = str.charAt(j);
                if(graph[i][j]=='J') jq.offer(new Node(j, i));
                if(graph[i][j]=='F') fq.offer(new Node(j, i));
            }
        }

        bfs();
    }
}
