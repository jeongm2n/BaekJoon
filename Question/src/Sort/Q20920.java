package Sort;

import java.io.*;
import java.util.*;

public class Q20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            
            if(s.length()<M) continue;

            hm.put(s, hm.getOrDefault(s, 0)+1);
        }

        ArrayList<String> arr = new ArrayList<>(hm.keySet());

        Collections.sort(arr, (o1,o2)->{
            if(hm.get(o2)==hm.get(o1)){
                if(o1.length()==o2.length()) return o1.compareTo(o2);
                return o2.length()-o1.length();
            }
            return hm.get(o2) - hm.get(o1);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
