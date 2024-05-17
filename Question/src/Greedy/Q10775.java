package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10775 {
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

        int G = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        parent = new int[G+1];

        for(int i=0; i<=G; i++){
            parent[i] = i;
        }

        int result = 0;

        for(int i=0; i<n; i++){
            int g = Integer.parseInt(br.readLine());
            int emptyg = find(g);

            if(emptyg==0) break;

            result++;
            union(emptyg, emptyg-1);
        }

        System.out.println(result);
    }
}
