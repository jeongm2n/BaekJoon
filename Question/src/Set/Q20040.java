package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20040 {
    static int[] parent;

    static int find(int x){
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a>b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(find(s) == find(e)){
                System.out.println(i);
                return;
            }else union(s,e);
        }
        System.out.println(0);
    }   
}
