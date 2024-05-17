package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1043 {
    static int[] parent;
    static boolean[] trues;

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

        parent = new int[n+1];
        trues = new boolean[n+1];
        int result = 0;

        for(int i=1; i<=n; i++) parent[i] = i;

        ArrayList<Integer>[] parties = new ArrayList[m+1];

        for(int i=1; i<=m; i++) parties[i] = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        for(int i=0; i<k; i++){
            trues[Integer.parseInt(st.nextToken())] = true;
        }
            
        int pre = 0;

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
                
            pre = Integer.parseInt(st.nextToken());
            parties[i].add(pre);

            for(int j=1; j<a; j++){
                int b = Integer.parseInt(st.nextToken());
                parties[i].add(b);
                union(pre, b);
                pre = b;
            }
        }

        for(int i=1; i<=n; i++){
            if(trues[i]) trues[find(i)] = true;
        }

        for(int i=1; i<=m; i++){
            int parent = find(parties[i].get(0));
            if(!trues[parent]) result++;
        }
        
        System.out.println(result);
    }
}
