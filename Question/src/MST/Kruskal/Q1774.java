package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1774 {
    static int[] parent;
    static Node[] nodes;
    static int N;

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int s, e;
        double w;
        public Edge(int s, int e, double w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            if(w<o.w) return -1;
            return 1;
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

    static double kruskal(){
        ArrayList<Edge> list = new ArrayList<>();
        double result = 0;

        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                Node start = nodes[i];
                Node end = nodes[j];
                double w = Math.sqrt(Math.pow(start.x-end.x, 2) + Math.pow(start.y-end.y, 2));
                list.add(new Edge(i, j, w));
            }
        }
        
        Collections.sort(list);

        for(Edge e : list){
            if(find(e.s)==find(e.e)) continue;
            union(e.s,e.e);
            result += e.w;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        nodes = new Node[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        double result = kruskal();
        System.out.println(String.format("%.2f", result));
    }
}
