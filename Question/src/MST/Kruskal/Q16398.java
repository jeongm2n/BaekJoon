package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16398 {
    static class Planet{
        int s, e, w;
        public Planet(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int N;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        StringTokenizer st;
        ArrayList<Planet> arr = new ArrayList<>();

        for(int i=1; i<=N; i++){
            parent[i] = i;
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++){
                int w = Integer.parseInt(st.nextToken());
                arr.add(new Planet(i, j, w));
            }
        }

        Collections.sort(arr, (o1,o2)->{
            return o1.w - o2.w;
        });

        long result = 0;
        int cnt = 0;
        for(Planet p : arr){
            if(find(p.s)!=find(p.e)){
                union(p.s, p.e);
                cnt++;
                result += p.w;
                if(cnt==N-1) break;
            }
        }

        System.out.println(result);
    }
}
