
import java.io.*;

public class Q1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String eight = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<eight.length(); i++){
            int a = eight.charAt(i) - '0';
            String s = Integer.toBinaryString(a);

            //if(s.length()==3) sb.append(s);
            if(s.length()==2 && i!=0) sb.append("0"+s);
            else if(s.length()==1 && i!=0) sb.append("00"+s);
            else sb.append(s);
        }

        System.out.println(sb);
    }
}
