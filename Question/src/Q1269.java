import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> hsA = new HashSet<>();
        Set<Integer> hsB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            hsA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            hsB.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;

        for(int i : hsA){
            if(!hsB.contains(i)) cnt++;
        }
        for(int i: hsB){
            if(!hsA.contains(i)) cnt++;
        }

        System.out.println(cnt);
    }
}
