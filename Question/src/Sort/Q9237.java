package Sort;

import java.io.*;
import java.util.*;

public class Q9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) arr.add(Integer.parseInt(st.nextToken()));

        Collections.sort(arr, (o1,o2)->{return o2-o1;});

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            max = Math.max(i+1 + arr.get(i), max);
        }

        System.out.println(max+1);
    }
}
