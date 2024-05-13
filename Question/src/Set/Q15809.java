package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15809 {
    static int[] army, parent;

    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(army[x]>army[y]){
            parent[y] = x;
            army[x] -= army[y];
        }else if(army[y]>army[x]){
            parent[x] = y;
            army[y] -= army[x];
        }else{
            parent[x] = 0;
            parent[y] = 0;
            army[x] = 0;
            army[y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        army = new int[n+1];
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            army[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int o = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(o==1){
                if(army[p]>army[q]){
                    army[p] += army[q];
                    army[q] = 0;
                    parent[q] = p;
                }else{
                    army[q] += army[p];
                    army[p] = 0;
                    parent[p] = q;
                }
            }else{
                union(p,q);
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int x : army){
            if(x>0) arr.add(x);
        }

        sb.append(arr.size()).append("\n");
        for(int x : arr) sb.append(x + " ");

        System.out.println(sb);

    }
}
