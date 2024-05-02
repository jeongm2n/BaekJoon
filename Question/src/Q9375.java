import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        HashMap<String,Integer> hm;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            int result = 1;

            int n = Integer.parseInt(br.readLine());

            hm = new HashMap<>();

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();

                String s = st.nextToken();

                hm.put(s, hm.getOrDefault(s, 0)+1);
            }

            for(int a : hm.values()){
                result *= (a+1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}
