package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + M];

        System.arraycopy(A, 0, arr, 0, N);
        System.arraycopy(B, 0, arr, N, M);

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i + " ");

        System.out.println(sb);
    }   
}
