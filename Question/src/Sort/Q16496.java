package Sort;

import java.io.*;
import java.net.CookieHandler;
import java.util.*;

public class Q16496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        boolean flag = true;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            String s = st.nextToken();
            arr.add(s);
            if(!s.equals("0")) flag = false;
        }

        if(flag) System.out.println(0);
        else{
            Collections.sort(arr, (o1,o2)->{
                return (o2+o1).compareTo(o1+o2);
            });
            
            String answer = "";
            for(String s : arr) answer += s;
            System.out.println(answer);
        }
    }
}
