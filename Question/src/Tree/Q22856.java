package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22856 {
    static int[][] tree;
    static int cnt = 0;
    static int lastNode = 0;

    static void dfs(int s){
        if(tree[s][0]!=-1) dfs(tree[s][0]);
        lastNode = s;
        if(tree[s][1]!=-1) dfs(tree[s][1]);
    }

    static void inorder(int s){
        if(tree[s][0]!=-1){
            cnt++;
            inorder(tree[s][0]);
        }
        if(tree[s][1]!=-1){
            cnt++;
            inorder(tree[s][1]);
        }

        if(lastNode==s){
            System.out.println(cnt);
            System.exit(0);
        }

        cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        tree = new int[N+1][2];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());   
            int c = Integer.parseInt(st.nextToken());

            tree[a][0] = b;
            tree[a][1] = c;
        }

        dfs(1);
        inorder(1);
        System.out.println(cnt);
    }
}
