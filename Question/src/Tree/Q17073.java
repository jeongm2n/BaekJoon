package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int cnt = 0;

        for(int i=2; i<=N; i++){
            if(tree[i].size()==1) cnt++;
        }

        double result = W/(double)cnt;
        System.out.println(result);
    }
}
