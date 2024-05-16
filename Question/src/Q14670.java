import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            for(int j=0; j<a; j++){
                int b = Integer.parseInt(st.nextToken());
                if(!map.containsKey(b)){
                    sb.setLength(0);
                    sb.append("YOU DIED");
                    break;
                }
                sb.append(map.get(b) + " ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
