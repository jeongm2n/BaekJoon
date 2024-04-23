package Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = 1; int max = arr[n-1];

        while(min<=max){
            int mid = (min+max)/2;
            int cnt = 1;
            int position = 0; //1번 집에는 무조건 설치한다고 가정

            for(int i=1; i<n; i++){
                if(arr[i] - arr[position] >= mid){
                    position = i;
                    cnt++;
                }
            }

            if(cnt < c) max = mid-1;
            else min = mid+1;
        }
        System.out.println(min-1);
    }
}
