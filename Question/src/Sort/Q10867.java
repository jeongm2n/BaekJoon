package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(hs.contains(a)) continue;
            hs.add(a);
            arr.add(a);
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i + " ");

        System.out.println(sb);
    }
}
