package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q1414 {
    static class Edge{
        int s, e, w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w =w;
        }
    }
    static ArrayList<Edge> list = new ArrayList<>();
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

    static void kruskal(int sum){
        int result = 0;
        int cnt = 0;

        for(Edge E : list){
            if(find(E.s)==find(E.e)) continue;
            union(E.s, E.e);
            result += E.w;
            cnt++;
            if(cnt==N-1) break;
        }

        if(cnt==N-1) System.out.println(sum - result);
        else System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        int sum = 0;
        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                char c = s.charAt(j);
                if(c=='0') continue;

                int len = 0;
                if(c>='a' && c<='z'){
                    len = (int)c-96;
                    list.add(new Edge(i, j+1, len));
                }else if(c>='A' && c<='Z'){
                    len = (int)c-38;
                    list.add(new Edge(i, j+1, len));
                }
                sum += len;
            }
        }

        Collections.sort(list, (o1,o2)->{return o1.w-o2.w;});
        kruskal(sum);
    }
}
