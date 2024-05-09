package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11505 {
    static int MOD = 1000000007;
    static long arr[];
    static long tree[];

    static long makeTree(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end)/2;
        return tree[node] = (makeTree(node*2, start, mid) * makeTree(node*2+1, mid+1, end))%MOD;
    }

    static long mult(int node, int start, int end, int left, int right){
        if(end<left || right<start) return 1;
        else if(left<=start && end<=right) return tree[node];
        else{
            int mid = (start + end)/2;
            return (mult(node*2, start, mid, left, right) * mult(node*2+1, mid+1, end, left, right))%MOD;
        }
    }

    static long update(int node, int start, int end, int idx, long val){
        if(idx<start || end<idx) return tree[node];
        if(start == end){
            return tree[node] = val;
        }
        int mid = (start + end)/2;

        return tree[node] = (update(node*2, start, mid, idx, val)*update(node*2+1, mid+1, end, idx, val))%MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        tree = new long[n*4];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeTree(1, 1, n);

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if(a==1){
                arr[b] = c;
                update(1, 1, n, b, c);
            }else{
                sb.append(mult(1,1,n,b,(int)c)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
