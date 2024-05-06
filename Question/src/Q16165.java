import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> map = new HashMap<>();

        for(int z=0; z<n; z++){
            List<String> li = new ArrayList<>();
            String tname = br.readLine();
            int mem = Integer.parseInt(br.readLine());
            for(int y=0; y<mem; y++){
                li.add(br.readLine());
            }
            map.put(tname, li);
        }  
        
        StringBuilder sb = new StringBuilder();

        for(int z=0; z<m; z++){
            String str = br.readLine();
            int com = Integer.parseInt(br.readLine());

            if(com==0){
                List<String> li = map.get(str);
                Collections.sort(li);
                for(String s : li){
                    sb.append(s).append("\n");
                }
            }else{
                for(String s : map.keySet()){
                    if(map.get(s).contains(str)){
                        sb.append(s).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
