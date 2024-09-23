package Sort;

import java.io.*;
import java.util.*;

public class Q1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<N; i++) arr[i] = br.readLine();

        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            boolean flag = true;
            for(int j=0; j<N; j++){
                if(arr[i].equals(arr[j])) continue;
                if(arr[j].startsWith(arr[i])){
                    flag = false;
                    break;
                }
            }
            if(flag) hs.add(arr[i]);
        }

        System.out.println(hs.size());
    }
}
