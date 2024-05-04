import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        HashSet<String> hs = new HashSet<>();
        int result = 0;

        for(int i=0; i<n; i++){
            String id = br.readLine();
            if(id.equals("ENTER")){
                result += hs.size();
                hs = new HashSet<>();
            }else hs.add(id);
        }
        result += hs.size();
        System.out.println(result);
    }
}
