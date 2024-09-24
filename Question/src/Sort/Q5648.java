package Sort;

import java.io.*;
import java.util.*;

public class Q5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] splits = line.split(" ");
        
        int N = Integer.parseInt(splits[0]);
        ArrayList<Integer> arr = new ArrayList<>();
        
        int cnt = 0;
        StringBuffer b;

        if(splits.length>1){
            for(int i=1; i<splits.length; i++){
                b = new StringBuffer(splits[i]);
                arr.add(Integer.parseInt(b.reverse().toString()));
            }
            cnt = splits.length-1;
        }
        
        while(cnt<N){
            line = br.readLine();
            splits = line.split(" ");
            for(String s : splits){
                b = new StringBuffer(s);
                arr.add(Integer.parseInt(b.reverse().toString()));
            }
            cnt += splits.length;
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i + "\n");
        System.out.println(sb);
    }
}
