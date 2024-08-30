package Sort;

import java.io.*;
import java.util.*;

public class Q5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();

            for(int j=0; j<N; j++) arr.add(Integer.parseInt(st.nextToken()));
            Collections.sort(arr,(o1,o2)->{return o2-o1;});
            int max = arr.get(0);
            int min = arr.get(N-1);

            int lgap = Integer.MIN_VALUE;
            for(int j=0; j<N-1; j++){
                int gap = arr.get(j) - arr.get(j+1);
                if(lgap<gap) lgap = gap;
            }

            sb.append("Class "+i).append("\n");
            sb.append("Max "+max+", Min "+min+", Largest gap "+lgap).append("\n");
        }
        System.out.println(sb);
    }
}
