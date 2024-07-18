package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11085 {
    static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
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

    static int result(int C, int V){
        int ans = 0;

        for(Edge l : list){
            if(find(l.u)==find(l.v)) continue;
            union(l.u, l.v);

            if(find(C)==find(V)) {
                ans = l.w;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        parent = new int[p+1];
        for(int i=1; i<=p; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=0; i<W; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(u, v, w));
        }

        Collections.sort(list, (o1,o2)->{return o2.w-o1.w;});

        System.out.println(result(C, V));
    }
}
