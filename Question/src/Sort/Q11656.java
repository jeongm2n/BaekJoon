package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        
        String[] arr = new String[len];

        for(int i=0; i<len; i++){
            String s = "";
            for(int j=i; j<len; j++){
                s += str.charAt(j);
            }
            arr[i] = s;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
