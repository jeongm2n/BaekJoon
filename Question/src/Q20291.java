import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str;
        HashMap<String,Integer> map =new HashMap<>();
      
        for(int i=0; i<n; i++){
            str = br.readLine();
            String[] s = str.split("\\.");
            map.put(s[1],map.getOrDefault(s[1], 0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        StringBuilder sb = new StringBuilder();

        for(String s : keySet){
            sb.append(s + " ").append(map.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}
