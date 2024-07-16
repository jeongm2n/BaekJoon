package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1647 {
    static class Edge implements Comparable<Edge>{
        int u, v;
        long w;

        public Edge(int u, int v, long w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return (int)this.w - (int)o.w;
        }
    }

    static int[] parent;
    static int N;
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
        int cnt = 0;
        long sum = 0;

        for(Edge l : list){
            if(find(l.u)==find(l.v)) continue;
            if(cnt==N-2) return sum;
            union(l.u, l.v);
            sum += l.w;
            cnt++;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i=1; i<=N; i++) parent[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            list.add(new Edge(u, v, w));
        }

        Collections.sort(list);

        System.out.println(kruskal());
    }
}
