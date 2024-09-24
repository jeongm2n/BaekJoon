package Sort;

import java.io.*;
import java.util.*;

public class Q1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            list.add(arr[i]);
        }

        int min = 4;
        for (int i = 0; i < n-1; i++) {
            int cnt = 1;
            for (int j = arr[i]+1; j < arr[i]+5; j++) {
                if (list.contains(j))
                    cnt++;
            }
            min = Math.min(min, 5-cnt);
        }
        
        System.out.println(min);
    }
}
