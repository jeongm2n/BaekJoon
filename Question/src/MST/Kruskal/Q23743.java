package MST.Kruskal;

import java.io.*;
import java.util.*;

public class Q23743 {
    static int[] parent;
    static int N, M;
    static ArrayList<Edge> edges;

    static class Edge{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }

    static int kruskal(){
        int result = 0;

        for(Edge E : edges){
            if(find(E.s)==find(E.e)) continue;
            union(E.s, E.e);
            result += E.w;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, w));
        }

        parent = new int[N+1];

        for(int i=0; i<=N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) edges.add(new Edge(0, i, Integer.parseInt(st.nextToken())));

        Collections.sort(edges, (o1,o2)->{return o1.w-o2.w;});

        System.out.println(kruskal());
    }
}
