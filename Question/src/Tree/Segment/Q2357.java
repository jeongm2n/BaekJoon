package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2357 {
    static long arr[];
    static long maxTree[];
    static long minTree[];

    static long makeMax(int node, int start, int end){
        if(start == end) return maxTree[node] = arr[start];
        int mid = (start+end)/2;
        return maxTree[node] = Math.max(makeMax(node*2,start,mid), makeMax(node*2+1,mid+1,end));
    }

    static long makeMin(int node, int start, int end){
        if(start == end) return minTree[node] = arr[start];
        int mid = (start+end)/2;
        return minTree[node] = Math.min(makeMin(node*2,start,mid), makeMin(node*2+1,mid+1,end));
    }

    static long max(int node, int start, int end, int left, int right){
        if(end<left || right<start) return Integer.MIN_VALUE;
        else if(left<=start && end<=right) return maxTree[node];
        else{
            int mid = (start+end)/2;
            return Math.max(max(node*2,start,mid,left,right), max(node*2+1,mid+1,end,left,right));
        }
    }

    static long min(int node, int start, int end, int left, int right){
        if(end<left || right<start) return Integer.MAX_VALUE;
        else if(left<=start && end<=right) return minTree[node];
        else{
            int mid = (start+end)/2;
            return Math.min(min(node*2,start,mid,left,right), min(node*2+1,mid+1,end,left,right));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n+1];

        double h = Math.ceil(Math.log(n)/Math.log(2))+1;
        long many = Math.round(Math.pow(2,h));
        maxTree = new long[Math.toIntExact(many)];
        minTree = new long[Math.toIntExact(many)];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeMax(1, 1, n);
        makeMin(1, 1, n);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(1, 1, n, a, b) + " " + max(1, 1, n, a, b)).append("\n");
        }

        System.out.println(sb);
    }
}
