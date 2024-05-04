import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        HashMap<String,Integer> map = new HashMap<>();
        String tree;

        while((tree = br.readLine())!=null){
            cnt++;
            map.put(tree, map.getOrDefault(tree, 0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        StringBuilder sb = new StringBuilder();

        for(String s : keySet){
            int num = map.get(s);
            sb.append(s).append(" ").append(String.format("%.4f",(double)num*100/(double)cnt)).append("\n");
        }
        System.out.println(sb);
    }
}
