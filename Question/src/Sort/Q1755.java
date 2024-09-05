package Sort;

import java.io.*;
import java.util.*;

public class Q1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alp = {"zero","one","two","three","four","five","sixth","seven","eight","nine"};
        HashMap<Integer, String> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=M; i<=N; i++){
            String s = String.valueOf(i);
            String str = "";
            for(int j=0; j<s.length(); j++){
                int c = s.charAt(j)-'0';
                str += alp[c] + " ";
            }
            map.put(i, str);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (o1,o2)->{
            return map.get(o1).compareTo(map.get(o2));
        });

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i : arr){
            sb.append(i + " ");
            cnt++;
            if(cnt%10==0) sb.append("\n");
        }

        System.out.println(sb);
    }
}
