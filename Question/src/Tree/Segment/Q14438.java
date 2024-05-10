package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14438 {
    static int[] arr;
    static int[] tree;

    static int makeTree(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end)/2;
        return tree[node] = Math.min(makeTree(node*2, start, mid), makeTree(node*2+1, mid+1, end));
    }

    static int min(int node, int start, int end, int left, int right){
        if(end<left || right<start) return Integer.MAX_VALUE;
        else if(left<=start && end<=right) return tree[node];
        else{
            int mid = (start + end)/2;
            return Math.min(min(node*2, start, mid, left, right), min(node*2+1, mid+1, end, left, right));
        }
    }

    static int update(int node, int start, int end, int idx, int val){
        if(start>idx || end<idx) return tree[node];
        if(start == end) return tree[node] = val;
        int mid = (start + end)/2;
        return tree[node] = Math.min(update(node*2, start, mid, idx, val), update(node*2+1, mid+1, end, idx, val));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        tree = new int[n*4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());        
        }

        int m = Integer.parseInt(br.readLine());
        makeTree(1, 1, n);
        StringBuilder sb = new StringBuilder();

        for(int z=0; z<m; z++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(command == 1){
                update(1, 1, n, i, v);
            }else{
                if(i>v){
                    int tmp = i;
                    i  = v;
                    v = tmp;
                }
                sb.append(min(1, 1, n, i, v)).append("\n");
            }
        }

        System.out.println(sb);
    }

}
