import java.io.*;
import java.util.*;

public class Q4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0) break;

            arr.add(a);
            arr.add(b);
            arr.add(c);

            Collections.sort(arr,(o1,o2)->{return o2-o1;});

            long a2 = (long)Math.pow(arr.get(0), 2);
            long b2 = (long)Math.pow(arr.get(1), 2);
            long c2 = (long)Math.pow(arr.get(2), 2);

            sb.append(a2==b2+c2 ? "right" : "wrong").append("\n");
        }

        System.out.println(sb);
    }
}
