package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dis = new long[n-1];
        long[] oil = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n-1; i++){
            dis[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long min = oil[0];

        for(int i=0; i<n-1; i++){
            if(oil[i]<min) min=oil[i];
            sum += min*dis[i];
        }

        System.out.println(sum);
    }
}
