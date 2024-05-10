package Tree.Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5676 {
    static int arr[];
    static int tree[];

    static int makeTree(int node, int s, int e){
        if(s==e) return tree[node] = arr[s];
        int mid = (s+e)/2;
        return tree[node] = makeTree(node*2, s, mid) * makeTree(node*2+1, mid+1, e);
    }

    static int mult(int node, int s, int e, int l, int r){
        if(e<l || r<s) return 1;
        else if(l<=s || e<=r) return tree[node];
        int mid = (s+e)/2;
        return mult(node*2, s, mid, l, r) * mult(node*2+1, mid+1, e, l, r);
    }

    static int update(int node, int s, int e, int idx, int val){
        if(idx<s || e<idx) return tree[node];
        if(s==e) return tree[node] = val;
        int mid = (s+e)/2;
        return tree[node] = update(node*2, s, mid, idx, val) * update(node*2+1, mid+1, e, idx, val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            String input = br.readLine();
            if(input==null) break;
            
            st = new StringTokenizer(input);

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
    
            arr = new int[n+1];
            tree = new int[n*4];
    
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i] = (tmp == 0) ? 0 : (tmp > 0) ? 1 : -1;
            }
    
            makeTree(1, 1, n);
    
            for(int z=0; z<k; z++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int i = Integer.parseInt(st.nextToken());
    
                if(command.equals("C")){
                    int v = Integer.parseInt(st.nextToken());
                    v = (v == 0) ? 0 : (v > 0) ? 1 : -1;
                    update(1, 1, n, i, v);
                }else{
                    int j = Integer.parseInt(st.nextToken());

                    if(i>j){
                        int tmp = i;
                        i = j;
                        j = tmp;
                    }
                    long res = mult(1, 1, n, i, j);
                    sb.append((res==0) ? 0 : (res>0) ? "+" : "-");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
