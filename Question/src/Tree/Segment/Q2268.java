package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2268 {
    static long[] tree;

    static long sum(int node, int start, int end, int left, int right){
        if(end<left || right<start) return 0;
        else if(left<=start && end<=right) return tree[node];
        else{
            int mid = (start + end)/2;
            return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
        }
    }

    static long update(int node, int start, int end, int idx, int val){
        if(idx<start || end<idx) return tree[node];
        if(start==end) return tree[node] = val;

        int mid = (start+end)/2;
        return tree[node] = update(node*2, start, mid, idx, val) + update(node*2+1, mid+1, end, idx, val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new long[n*4];
        
        StringBuilder sb = new StringBuilder();

        for(int z=0; z<m; z++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(command == 0){
                if(i>j){
                    int tmp = i;
                    i = j;
                    j = tmp;
                }
                sb.append(sum(1,1,n,i,j)).append("\n");
            }else{
                update(1,1,n,i,j);
            }
        }

        System.out.println(sb);
    }
}
