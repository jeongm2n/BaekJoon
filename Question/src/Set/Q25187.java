package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25187 {
    static int[] parent, tank;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        tank = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int c = Integer.parseInt(st.nextToken());
            tank[i] = (c==1 ? 1 : -1);
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            union(u,v);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<q; i++){
            int k = Integer.parseInt(br.readLine());

            int clean = 0;
            int dirty = 0;

            for(int j=1; j<=n; j++){
                if(parent[j]==parent[k]){
                    if(tank[j] == 1) clean++;
                    else dirty++;
                }
            }
            if(clean>dirty) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }   
}
