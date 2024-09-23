package Sort;

import java.util.*;
import java.io.*;

public class Q1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int i=0; i<N-1; i+=2){
            int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
                cnt++;
                if(cnt==S){
                    StringBuilder sb = new StringBuilder();
                    for(int j : arr) sb.append(j + " ");
                    System.out.println(sb);
                    return;
                }
        }
    }
}
