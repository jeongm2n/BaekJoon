package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1197 {
    static class Edge{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int[] parent;
    static ArrayList<Edge> list = new ArrayList<>();

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

    static long kruskal(){
        long w = 0;

        for(Edge l : list){
            int s = l.s;
            int e = l.e;

            if(find(s)==find(e)) continue;
            union(s, e);
            w += l.w;
        }

        return w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1; i<=V; i++) parent[i] = i;

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, w));
        }

        Collections.sort(list, (o1,o2)->{return o1.w-o2.w;});

        System.out.println(kruskal());
    }
}
