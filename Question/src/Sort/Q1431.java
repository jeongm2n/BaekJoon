package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            arr.add(s);
        }

        Collections.sort(arr, (o1,o2)->{
            if(o1.length()==o2.length()){
                int sum1 = 0 , sum2 = 0;
                for(int i=0; i<o1.length(); i++){
                    if(o1.charAt(i)>='0' && o1.charAt(i)<='9') sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                    if(o2.charAt(i)>='0' && o2.charAt(i)<='9') sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                }
                if(sum1==sum2) return o1.compareTo(o2);
                return sum1 - sum2;
            }
            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s).append("\n");
        System.out.println(sb);
    }
}
