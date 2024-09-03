package Sort;

import java.io.*;
import java.util.*;

public class Q1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr, (o1,o2)->{return o2-o1;});

        long sum = 0;

        for(int i=1; i<=N; i++){
            int tmp = arr.get(i-1) - (i-1);
            if(tmp<0) continue;
            sum += tmp; 
        }

        System.out.println(sum);
    }
}