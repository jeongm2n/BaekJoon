package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10868 {
    static long[] arr;
    static long[] tree;

    static long makeTree(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = Math.min(makeTree(node*2, start, mid),makeTree(node*2+1, mid+1, end));
    }

    static long min(int node, int start, int end, int left, int right){
        if(end<left || right<start) return Integer.MAX_VALUE;
        else if(left<=start && end<=right) return tree[node];
        else{
            int mid = (start+end)/2;
            return Math.min(min(node*2, start, mid, left, right),min(node*2+1, mid+1, end, left, right));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        double h = Math.ceil(Math.log(n)/Math.log(2))+1;
        long many = Math.round(Math.pow(2,h));

        arr = new long[n+1];
        tree = new long[Math.toIntExact(many)];

        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        makeTree(1, 1, n);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(1, 1, n, a, b)).append("\n");
        }

        System.out.println(sb);
    }
}
