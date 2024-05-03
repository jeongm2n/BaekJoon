import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            hm.put(site,pwd);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            String site = br.readLine();
            sb.append(hm.get(site)).append("\n");
        }
        System.out.println(sb);
    }
}
