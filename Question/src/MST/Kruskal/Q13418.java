package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13418 {
    static class Node{
        int s, e, dir;
        public Node(int s, int e, int dir){
            this.s = s;
            this.e = e;
            this.dir = dir;
        }
    }

    static ArrayList<Node> edges = new ArrayList<>();
    static int[] parent;
    static int N;

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

    static int worst(int cnt){
        Collections.sort(edges, (o1,o2)->{return o1.dir-o2.dir;});
        for(int i=0; i<=N; i++) parent[i] = i;
        int edge = 0;
        for(Node n : edges){
            int s = n.s;
            int e = n.e;

            if(find(s)==find(e)) continue;
            if(edge==N-1) break;
            union(s, e);
            edge++;
            if(n.dir==0) cnt++;
        }

        return cnt*cnt;
    }

    static int best(int cnt){
        Collections.sort(edges, (o1,o2)->{return o2.dir-o1.dir;});
        for(int i=0; i<=N; i++) parent[i] = i;
        int edge = 0;

        for(Node n : edges){
            int s = n.s;
            int e = n.e;

            if(find(s)==find(e)) continue;
            if(edge==N-1) break;
            union(s, e);
            edge++;
            if(n.dir==0) cnt++;
        }

        return cnt*cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int w = 0;
        for(int i=0; i<3; i++){
            w = Integer.parseInt(st.nextToken());
        }
        int dir = 0 ;

        if(w==0) dir=1;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges.add(new Node(s, e, w));
        }

        int worst = worst(dir);
        int best = best(dir);

        System.out.println(worst - best);
    }
}
