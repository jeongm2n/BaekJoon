package MST.Kruskal;

import java.io.*;
import java.util.*;;

public class Q17490 {
    static class Edge{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int N, M, K;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i-1;

        parent[1] = N;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(0, i, v));
        }

        Collections.sort(edges, (o1,o2)->{return o1.w - o2.w;});

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = Math.max(a,b);
            int min = Math.min(a,b);

            if(min==1 && max==N){
                parent[1] = 1;
                continue;
            }
            parent[max] = max;
        }

        if(M<2) {
            System.out.println("YES");
            return;
        }
        long result = 0;

        for(Edge l : edges){
            if(find(l.s)==find(l.e)) continue;
            union(l.s, l.e);
            result += l.w;
        }

        System.out.println(result<=K ? "YES" : "NO");
    }
}
