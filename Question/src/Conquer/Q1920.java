package Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] marr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            marr[i] = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(arr, marr[i])<0) sb.append(0).append("\n");
            else sb.append(1).append("\n");
        }

        System.out.println(sb);
    }
}
