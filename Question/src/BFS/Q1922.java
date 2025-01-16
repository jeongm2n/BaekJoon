package BFS;

import java.io.*;
import java.util.*;

public class Q1922 {
    static int N, M, parent[];
    static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static ArrayList<Edge> edges = new ArrayList<>();

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x<y) parent[y] = x;
        else parent[x] = y;
    }

    static int kruskal(){
        int result = 0;

        for(Edge e : edges){
            int u = e.u;
            int v = e.v;

            if(find(u)==find(v)) continue;
            union(u,v);
            result += e.w;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i=1; i<=N; i++) parent[i] = i;

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges, (o1,o2)->{return o1.w-o2.w;});

        System.out.println(kruskal());
    }
}
