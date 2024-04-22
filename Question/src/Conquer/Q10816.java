package Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(!map.containsKey(a)) map.put(a,1);
            else map.put(a, map.get(a)+1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int a = Integer.parseInt(st.nextToken());
            if(!map.containsKey(a)) sb.append(0).append(" ");
            else sb.append(map.get(a)).append(" ");
        }
        System.out.println(sb);
    }
}
