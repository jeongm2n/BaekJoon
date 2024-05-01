package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1717 {
    static int[] parent;

    static int find(int x){
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(a>b) parent[a] = b;
            else parent[b] = a;
        }
    }

    static String parentChk(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b) return "NO";
        else return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i=0; i<=n; i++) parent[i] = i;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(command){
                case 0:
                    union(a,b);
                    break;
                case 1:
                    sb.append(parentChk(a,b)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
