package BFS;

import java.io.*;
import java.util.*;

public class Q5427 {
    static int N, M;
    static char[][] graph;
    static Queue<Node> fire, person;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static class Node{
        int x, y, t;
        public Node(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static int bfs(){
        while(!person.isEmpty()){
            int size = fire.size();

            for(int i=0; i<size; i++){
                Node cur = fire.poll();

                for(int j=0; j<4; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(isRange(nx,ny) && (graph[ny][nx]=='.' || graph[ny][nx]=='@')){
                        fire.offer(new Node(nx, ny, 0));
                        graph[ny][nx] = '*';
                    }
                }
            }

            size = person.size();

            for(int i=0; i<size; i++){
                Node cur = person.poll();

                for(int j=0; j<4; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(!isRange(nx, ny)){
                        return cur.t+1;
                    }

                    if(graph[ny][nx]=='.'){
                        person.offer(new Node(nx, ny, cur.t+1));
                        graph[ny][nx] = '@';
                    }
                }
            }
        }
        
        return -1;
    }

    static boolean isRange(int x, int y){
        if(x>=0 && y>=0 && x<M && y<N) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
    
            graph = new char[N][M];
            person = new LinkedList<>();
            fire = new LinkedList<>();

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    graph[i][j] = str.charAt(j);
                    
                    if(graph[i][j]=='*') fire.offer(new Node(j, i, 0));
                    else if(graph[i][j]=='@') person.offer(new Node(j, i , 0));
                }
            }

            int result = bfs();

            sb.append(result==-1 ? "IMPOSSIBLE" : result).append("\n");
        }

        System.out.println(sb);
    }
}
