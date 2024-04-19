package Sort;
import java.io.*;

public class Q4779 {
    static StringBuilder sb;

    public static void space(int start, int size){
        if(size==1) return;

        int three = size/3;
        
        for(int i=start+three; i<start+(three*2); i++){
            sb.setCharAt(i, ' ');
        }
        space(start,three);
        space(start+(three*2),three);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine()) != null){
            int n = Integer.parseInt(s);
            sb = new StringBuilder();

            int p = (int) Math.pow(3,n);

            for(int i=0; i<p; i++){
                sb.append("-");
            }
            space(0,p);
            System.out.println(sb);
        }
    }    
}
