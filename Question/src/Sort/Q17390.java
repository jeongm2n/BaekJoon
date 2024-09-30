package Sort;

import java.util.*;
import java.io.*;

public class Q17390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i=1; i<=N; i++) sums[i] = sums[i-1] + arr[i-1];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(sums[e]-sums[s-1]).append("\n");
        }

        System.out.println(sb);
    }
}
