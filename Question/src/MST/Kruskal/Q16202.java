package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16202 {
    static class Edge implements Comparable<Edge>{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }    
    }
    static int[] parent;
    static int N, M, K;
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

    static int kruskal(){
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        int cnt = 0;
        int sum = 0;

        for(Edge l : list){
            int s = l.s;
            int e = l.e;

            if(find(s)==find(e)) continue;
            union(s,e);
            sum += l.w;
            cnt++;
        }
        if(cnt!=N-1) return 0;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, i));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            if(i>0) list.remove(0);
            sb.append(kruskal()).append(" ");
        }
        
        System.out.println(sb);
    }
}
