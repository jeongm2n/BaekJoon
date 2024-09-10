package Sort;

import java.io.*;
import java.util.*;

public class Q1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<M; i++) arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr);
        int cnt = 0;
        int sum = 0;

        for(int i=0; i<M; i++){
            int tmp = arr.get(i);
            int tmpSum = 0;
            
            if(M-i<N) tmpSum = (M-i) * tmp;
            else tmpSum = tmp * N;

            if(tmpSum>sum){
                sum = tmpSum;
                cnt = tmp;
            }
        }

        System.out.println(cnt + " " + sum);
    }
}
