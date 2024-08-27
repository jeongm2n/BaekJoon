import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<N; i++) hs.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }
}
