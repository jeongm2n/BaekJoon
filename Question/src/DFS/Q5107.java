package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q5107 {
    static HashMap<String, String> map = new HashMap<>();
    static String[] names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while(true){
            int N = Integer.parseInt(br.readLine());
        
            if(N==0) break;

            names = new String[N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                map.put(a, b);
                names[i] = a;
            }
            
            int sum = 0;
            
            for(String s : names){
                String e = map.get(s);
                while(true){
                    e = map.get(e);
                    if(e == null) break;
                    else if(e.equals(s)){
                        sum++;
                        map.keySet().remove(e);
                        break;
                    }
                }
            }
            sb.append(cnt + " " + sum).append("\n");
            cnt++;
        }

        System.out.println(sb);
    }   
}
