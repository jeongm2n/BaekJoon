package Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1939 {
    static int answer = Integer.MIN_VALUE;
    static ArrayList<City>[] graph;
    static boolean[] visited;
    static int start, end, n;

    static class City {
        int v,w;

        public City(int v, int w) {
        this.v = v;
        this.w = w;
        }
    }

    public static boolean bfs(int weight) {
        Queue<City> q = new LinkedList<>();
        visited = new boolean[n+1];
        q.offer(new City(start, 0));

        while(!q.isEmpty()) {
            City curr = q.poll();

            if(curr.v == end) return true;

            for(City next: graph[curr.v]) {
                if(weight <= next.w && !visited[next.v]) {
                    visited[next.v] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
        graph[i] = new ArrayList<City>();
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new City(v, w));
            graph[v].add(new City(u, w));

            low = Math.min(low, w);
            high = Math.max(high, w);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    
        while(low <= high) {
            int middle = (low + high) / 2;
            
            if(bfs(middle)) {
                low = middle + 1;
                answer = middle;
            }
            else high = middle - 1;
        }
        System.out.println(answer);
        
    }
}
