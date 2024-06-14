package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q10423 {
    static class Node{
        int s, e, w;
        public Node(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int[] parent;
    static ArrayList<Node> edges = new ArrayList<>();

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
        int cnt = 0;

        for(Node n : edges){
            if(find(n.s)==find(n.e)) continue;
            union(n.s, n.e);
            cnt += n.w;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) parent[Integer.parseInt(st.nextToken())] = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Node(u, v, w));
        }

        Collections.sort(edges, (o1,o2)->{return o1.w-o2.w;});

        System.out.println(kruskal());
    }
}
