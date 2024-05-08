package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10999 {
    static long[] arr, tree, lazy;

    static long makeTree(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        else{
            int mid = (start+end)/2;
            return tree[node] = makeTree(node*2, start, mid) + makeTree(node*2+1, mid+1, end);
        }
    }

    static void propagate(int node, int start, int end){
        if(lazy[node]!=0){
            if(start!=end){
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            tree[node] += lazy[node] * (end-start+1);
            lazy[node] = 0;
        }
    }

    static long sumTree(int node, int start, int end, int left, int right){
        propagate(node, start, end);
        if(end<left || right<start) return 0;
        else if(left<=start && end<=right) return tree[node];
        else{
            int mid = (start+end)/2;
            return sumTree(node*2, start, mid, left, right) + sumTree(node*2+1, mid+1, end, left, right);
        }
    }

    static void update(int node, int start, int end, int left, int right, long dif){
        propagate(node, start, end);
        if(end<left || right<start) return;
        else if(left<=start && end<=right){
            lazy[node] = dif;
            propagate(node, start, end);
            return;
        }

        int mid = (start+end)/2;
        update(node*2, start, mid, left, right, dif);
        update(node*2+1, mid+1, end, left, right, dif);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];

        double h = Math.ceil(Math.log(n)/Math.log(2))+1;
        long many = Math.round(Math.pow(2,h));
        tree = new long[Math.toIntExact(many)+1];
        lazy = new long[Math.toIntExact(many)+1];

        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        makeTree(1, 1, n);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==1){
                long d = Long.parseLong(st.nextToken());
                update(1,1,n,b,c,d);
            }else{
                sb.append(sumTree(1, 1, n, b, c)).append("\n");
            }

        }

        System.out.println(sb);
    }
}
