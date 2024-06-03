package MST.Kruskul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6497 {
    static class Light{
        int s, e, w;
        public Light(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int N;
    static ArrayList<Light> graph;
    static int[] parent;

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x<y) parent[y]=x;
        else parent[x] = y;
    }

    static int kruskul(int total){
        int result = 0;

        for(Light l : graph){
            int s = l.s;
            int e = l.e;
            int w = l.w;

            if(find(s)==find(e)) continue;
            union(s, e);
            result += w;
        }

        return total - result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;
            
            graph = new ArrayList<Light>();
            parent = new int[N];
            for(int i=0; i<N; i++) parent[i] = i;

            int total = 0;
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph.add(new Light(u, v, w));
                total += w;
            }

            Collections.sort(graph, (o1,o2)->{
                return o1.w - o2.w;
            });
            
            sb.append(kruskul(total)).append("\n");
        }
        System.out.println(sb);
    }
}
