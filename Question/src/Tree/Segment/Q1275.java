package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1275 {
    static long arr[];
    static long tree[];

    static long makeTree(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = makeTree(node*2, start, mid) + makeTree(node*2+1, mid+1, end);
    }

    static long sumTree(int node, int start, int end, int left, int right){
        if(end<left || right<start) return 0;
        else if(left<=start && end<=right) return tree[node];
        int mid = (start+end)/2;
        return sumTree(node*2, start, mid, left, right) + sumTree(node*2+1, mid+1, end, left, right);
    }

    static void update(int node, int start, int end, int idx, long dif){
        if(idx<start || end<idx) return;
        tree[node] += dif;
        if(start != end){
            int mid = (start+end)/2;
            update(node*2, start, mid, idx, dif);
            update(node*2+1, mid+1, end, idx, dif);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        tree = new long[n*4];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeTree(1, 1, n);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(x>y){
                int tmp = y;
                y = x;
                x = tmp;
            }

            sb.append(sumTree(1, 1, n, x, y)).append("\n");

            long dif = b - arr[a];
            arr[a] = b;
            update(1, 1, n, a, dif);
        }

        System.out.println(sb);
    }
}
