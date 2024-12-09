package MST.Kruskal;

import java.io.*;
import java.util.*;

public class Q9344 {
    static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public boolean isPQ(int p , int q){
            if(p != q && (p ==u || q == u) && (p == v || q == v)){
                return true;
            }
            return false;
        }
    }

    static int N, M, p, q;
    static int[] parent;
    static ArrayList<Edge> list;

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

    static String kruskal(){
        int cnt = 0;
        for(Edge e : list){
            if(find(e.u)==find(e.v)) continue;
            union(e.u, e.v);
            cnt++;

            if(e.isPQ(p, q)) return "YES";
            if(cnt==N-1) break;
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            list = new ArrayList<>();

            for(int i=1; i<=N; i++) parent[i] = i;

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.add(new Edge(u, v, w));
            }
            Collections.sort(list,(o1,o2)->{return o1.w-o2.w;});

            sb.append(kruskal()).append("\n");
        }
        System.out.println(sb);
    }   
}
