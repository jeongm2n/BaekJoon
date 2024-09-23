package Sort;

import java.io.*;
import java.util.*;

public class Q16212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for(int i : arr) sb.append(i + " ");
        System.out.println(sb);
    }
}
