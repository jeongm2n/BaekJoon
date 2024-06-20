package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21924 {
    static class Edge{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int N;
    static ArrayList<Edge> list = new ArrayList<>();
    static int[] parent;

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

    static void kruskal(long sum){
        int cnt = 0;

        for(Edge E : list){
            if(find(E.s)==find(E.e)) continue;
            union(E.s, E.e);
            sum -= E.w;
            cnt++;
            if(cnt==N-1) break;
        }

        System.out.println(cnt==N-1 ? sum : -1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i]=i;

        long sum = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, w));
            sum += w;
        }

        Collections.sort(list, (o1,o2)->{return o1.w-o2.w;});

        kruskal(sum);
    }
}
