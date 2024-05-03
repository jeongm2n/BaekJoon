import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(); 
        int max = 0;

        for(int i=0; i<n; i++){
            String title = br.readLine();
            map.put(title,map.getOrDefault(title, 0)+1);
            max = Math.max(max,map.get(title));
        }

        List<String> keys = new ArrayList<>();

        for(String s : map.keySet()){
            if(map.get(s)==max) keys.add(s);
        }

        Collections.sort(keys);

        System.out.println(keys.get(0));
    }
}
