package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18352 {
    static class City{
        int d, w;
        public City(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<City>[] graph;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Integer> arr = new ArrayList<>();

    static void bfs(int s, int k){
        Queue<City> q = new LinkedList<>();
        visited[s] = true;
        dist[s] = 0;
        q.offer(new City(s, 0));

        while(!q.isEmpty()){
            City c = q.poll();

            for(City n : graph[c.d]){
                int d = n.d;
                int w = n.w;

                if(!visited[d] && dist[d]>dist[c.d]+w){
                    visited[d] = true;
                    dist[d] = dist[c.d] + w;
                    q.offer(new City(d, dist[d]));
                    if(dist[d]==k) arr.add(d);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<City>();
        }

        Arrays.fill(dist, 100000001);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(new City(v, 1));
        }
        
        bfs(s, k);

        StringBuilder sb = new StringBuilder();
        Collections.sort(arr);

        if(arr.size()==0){
            sb.append(-1);
        }else{
            for(int i : arr){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
