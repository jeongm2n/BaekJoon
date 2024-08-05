package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2310 {
    static class Room{
        String K;
        int cost;
        public Room(String K, int cost){
            this.K = K;
            this.cost = cost;
        }
    }

    static class Mine{
        int d, m;
        public Mine(int d, int m){
            this.d = d;
            this.m = m;
        }
    }

    static ArrayList<Integer>[] graph;
    static Room[] list;
    static boolean[] visited;

    static boolean bfs(int N){
        Queue<Mine> q = new LinkedList<>();
        visited[1] = true;
        q.offer(new Mine(1, 0));

        while(!q.isEmpty()){
            Mine cur = q.poll();
            int d = cur.d;
            int m = cur.m;

            if(d==N) return true;

            for(int v : graph[d]){
                String s = list[v].K;
                int cost = list[v].cost;

                switch (s) {
                    case "E":
                        if(!visited[v]){
                            q.offer(new Mine(v, m));
                            visited[v] = true;
                        }
                        break;
                    
                    case "L":
                        if(!visited[v]){
                            if(m<cost) m=cost;
                            q.offer(new Mine(v, m));
                            visited[v] = true;
                        }
                        break;

                    case "T":
                        if(!visited[v] && m>=cost){
                            q.offer(new Mine(v, m-cost));
                            visited[v] = true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N==0) break;
        
            graph = new ArrayList[N+1];
            list = new Room[N+1];
            visited = new boolean[N+1];
    
            for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
            
            for(int i=1; i<=N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String K = st.nextToken();
                int c = Integer.parseInt(st.nextToken());
                
                list[i] = new Room(K, c);

                while(true){
                    int v = Integer.parseInt(st.nextToken());
                    if(v==0) break;

                    graph[i].add(v);
                }
            }

            sb.append(bfs(N) ? "Yes" : "No").append("\n");
        }

        System.out.println(sb);
        
    }
}
