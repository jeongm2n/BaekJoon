package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16562 {
    static int[] parent;
    static int[] moneys;

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(moneys[x]>moneys[y]) parent[x]=y;
        else parent[y]=x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        moneys = new int[N+1];
        boolean[] visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            parent[i] = i;
            moneys[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int sum = 0;

        for(int i=1; i<=N; i++){
            int parent = find(i);
            if(visited[parent]) {
                visited[i] = true;
                continue;
            }
            visited[i] = true;
            visited[parent] = true;
            sum += moneys[parent];
        }

        if(sum>k) System.out.println("Oh no");
        else System.out.println(sum);
    }
}
