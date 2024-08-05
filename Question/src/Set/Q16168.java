package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16168 {
    static ArrayList<Integer>[] list;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
            parent[i] = i;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
            union(u, v);
        }

        int p = find(1);
        for(int i=2; i<=N; i++){
            if(p!=find(i)){
                System.out.println("NO");
                System.exit(0);
            }
        }

        int cnt = 0;

        for(int i=1; i<=N; i++){
            if(list[i].size()%2==1) cnt++;
        }

        System.out.println(cnt==0 || cnt==2 ? "YES" : "NO");
    }
}
