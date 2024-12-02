package BFS;

import java.io.*;
import java.util.*;

public class Q20005 {
    static int M, N, P, HP;
    static char[][] graph;
    static boolean[][][] visited;
    static class Node{
        int x, y;
        char p;
        public Node(int x, int y, char p){
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    static class Player{
        int num, dps;
        public Player(int num, int dps){
            this.num = num;
            this.dps = dps;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Node> q = new LinkedList<>();
    static HashMap<Character, Player> hm = new HashMap<>();

    static int bfs(){
        ArrayList<Character> arr = new ArrayList<>();

        while(HP>0){
            while(!q.isEmpty()){
                Node cur = q.poll();

                if(graph[cur.y][cur.x]=='B' && !arr.contains(cur.p)){
                    arr.add(cur.p);
                    continue;
                }

                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || ny<0 || nx>=N || ny>=M || graph[ny][nx]=='X' || visited[ny][nx][hm.get(cur.p).num]) continue;
                    visited[ny][nx][hm.get(cur.p).num] = true;
                    q.offer(new Node(nx, ny, cur.p));
                }
            }
            
            for(char p : arr){
                HP -= hm.get(p).dps;
            }
        }

        return arr.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new char[M][N];
        visited = new boolean[M][N][P+1];

        for(int i=0; i<M; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = s.charAt(j);
                if(graph[i][j]!='.' && graph[i][j]!='B' && graph[i][j]!='X') q.offer(new Node(j, i, graph[i][j]));
            }
        }

        for(int i=1; i<=P; i++){
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            int dps = Integer.parseInt(st.nextToken());
            hm.put(p, new Player(i, dps));
        }

        HP = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }
}
