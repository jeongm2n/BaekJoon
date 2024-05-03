import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Long,Integer> map = new HashMap<>();
        int max = 0;

        for(int i=0; i<n; i++){
            long a = Integer.parseInt(br.readLine());
            map.put(a,map.getOrDefault(a, 0)+1);
            max = Math.max(max, map.get(a));
        }
        List<Long> arr = new ArrayList<>();

        for(long i : map.keySet()){
            if(map.get(i)==max) arr.add(i);
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
    }
}
