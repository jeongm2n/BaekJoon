package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr, (o1,o2)->{return o2-o1;});
        
        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i).append("\n");

        System.out.println(sb);
    }
}
