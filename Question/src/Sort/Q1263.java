package Sort;

import java.util.*;
import java.io.*;

public class Q1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr.add(new int[] {t, s});
        }

        Collections.sort(arr, (o1,o2)->{
            return o2[1]-o1[1];
        });

        int result = Integer.MAX_VALUE;
        for(int[] data : arr){
            result = Math.min(result, data[1]) - data[0];
            if(result<0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(result);
    }
}
