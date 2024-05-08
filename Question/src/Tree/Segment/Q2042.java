package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2042 {
    static long tree[];
    static long[] arr;

    static long makeTree(int node, int start, int end){
        //리프 노드이면 
        if(start==end) return tree[node] = arr[start];
        else{
            int mid = (start+end)/2;
            return tree[node] = makeTree(node*2, start, mid) + makeTree(node*2+1, mid+1, end);
        }
    }

    static long searchTree(int node, int start, int end, int left, int right){
        if(end<left || right<start) return 0;
        else if(left<=start && end<=right) return tree[node];
        else{
            int mid = (start+end)/2;
            return searchTree(node*2, start, mid, left, right) + searchTree(node*2+1, mid+1, end, left, right);
        }
    }

    static void update(int node, int start, int end, int idx, long dif){
        if(idx<start || end<idx) return;
        else{
            tree[node] += dif;

            if(start != end){
                int mid = (start+end)/2;
                update(node*2, start, mid, idx, dif);
                update(node*2+1, mid+1, end, idx, dif);
            }
        }
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

        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        makeTree(1, 1, n);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1){ //update
                long dif = c - arr[b];
                arr[b] = c;
                update(1,1,n,b,dif);
            }else{ //구간 합 출력
                sb.append(searchTree(1, 1, n, b, (int)c)).append("\n");
            }
        }

        System.out.println(sb);
        
    }
}
