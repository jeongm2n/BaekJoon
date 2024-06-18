package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17352 {
    static int N;
    static int[] parent;
    static ArrayList<Integer>[] graph;

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
        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        String s="";

        for(int i=2; i<=N; i++){
            if(find(1)!=find(i)){
                s = 1 + " " + i;
                break;
            }
        }

        System.out.println(s);

    }
}
