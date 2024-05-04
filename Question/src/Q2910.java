import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> origin = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);
            origin.add(a);
            map.put(a,map.getOrDefault(a, 0)+1);
        }

        Collections.sort(arr,(o1,o2)->{
            if(map.get(o1)==map.get(o2)) return origin.indexOf(o1) - origin.indexOf(o2);
            else return map.get(o2) - map.get(o1);
        });

        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
