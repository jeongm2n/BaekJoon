package Sort;

import java.util.*;
import java.io.*;

public class Q2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int i : arr) sb.append(i).append("\n");

        System.out.println(sb);
    }
}
