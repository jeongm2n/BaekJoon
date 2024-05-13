package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12837 {
    static long[] tree;

    public static long sum(int node, int s, int e, int left, int right){
        if(e<left || right<s) return 0;
        else if(left<=s && e<=right) return tree[node];
        int mid = (s+e)/2;
        return sum(node*2,s,mid,left,right) + sum(node*2+1,mid+1,e,left,right);
    }

    public static void update(int node, int s, int e, int idx, long val){
        if(s>idx || e<idx) return;
        tree[node] += val;
        if(s!=e){
            int mid = (s+e)/2;
            update(node*2, s, mid, idx, val);
            update(node*2+1, mid+1, e, idx, val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new long[n*4];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());

            if(query==1){
                int p = Integer.parseInt(st.nextToken());
                long x = Integer.parseInt(st.nextToken());

                update(1,1,n,p,x);
            }
            if(query==2){
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                sb.append(sum(1, 1, n, p, q)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
