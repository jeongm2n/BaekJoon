package Sort;

import java.util.*;
import java.io.*;

public class Q11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr = new ArrayList<>();

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr.add(r*c);
            }

            Collections.sort(arr, Collections.reverseOrder());

            int result = 0;
            for(int i : arr){
                if(J<=0) break;
                J-=i;
                result++; 
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }   
}
