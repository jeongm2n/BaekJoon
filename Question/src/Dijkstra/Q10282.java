package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10282 {
    static class Com{
        int d, w;
        public Com(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Com>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 10000001;

    static int dijkstra(int s){
        PriorityQueue<Com> q = new PriorityQueue<>((o1,o2)->{return o1.w-o2.w;});
        q.offer(new Com(s, 0));
        dist[s] = 0;
        int cnt = 0; 

        while(!q.isEmpty()){
            Com c = q.poll();

            if(!visited[c.d]){
                cnt++;
                visited[c.d] = true;
            }

            for(Com n : graph[c.d]){
                if(dist[n.d]>dist[c.d]+n.w){
                    dist[n.d] = dist[c.d] + n.w;
                    q.offer(new Com(n.d, dist[n.d]));
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

        while(T>0){
            T--;
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            dist = new int[n+1];
            visited = new boolean[n+1];

            for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
            Arrays.fill(dist, INF);

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[b].add(new Com(a, w));
            }
            
            int result = dijkstra(c);
            int max = 0;
            for(int i : dist){
                if(i!=INF){
                    max = Math.max(max, i);
                }
            }

            sb.append(result + " " + max).append("\n");
        }
        System.out.println(sb);
    }
}
