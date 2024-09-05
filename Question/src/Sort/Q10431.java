package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int[] arr;

        StringBuilder sb = new StringBuilder();

        for(int t=0; t<P; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            arr = new int[20];

            for(int i=0; i<20; i++) arr[i] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int i=0; i<20; i++){
                for(int j=0; j<i; j++) if(arr[j]>arr[i]) cnt++;
            }
            sb.append(T + " " + cnt).append("\n");
        }
        System.out.println(sb);
    }
}
