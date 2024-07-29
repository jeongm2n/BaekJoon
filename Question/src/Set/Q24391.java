package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q24391 {
    static int[] parent;
    static int[] schedule;

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x>y) parent[x]=y;
        else parent[y]=x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        schedule = new int[N+1];
        for(int i=1; i<=N; i++) parent[i]=i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) schedule[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for(int i=1; i<N; i++){
            int a = schedule[i];
            int b = schedule[i+1];

            if(find(a)!=find(b)) cnt++;
        }

        System.out.println(cnt);
    }
}
