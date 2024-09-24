package Sort;

import java.io.*;
import java.util.*;

public class Q5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Long> arr = new ArrayList<>();
        
        int cnt = 0;
        StringBuffer b;
        int N = 1;
        while(arr.size()<N){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(cnt==0) N = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                b = new StringBuffer(st.nextToken());
                arr.add(Long.parseLong(b.reverse().toString()));
            }
            cnt++;
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(long i : arr) sb.append(i + "\n");
        System.out.println(sb);
    }
}
