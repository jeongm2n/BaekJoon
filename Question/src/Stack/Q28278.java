package Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer s;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            s = new StringTokenizer(str);
            int command = Integer.parseInt(s.nextToken());
            switch(command){
                case 1: 
                    st.push(Integer.parseInt(s.nextToken()));
                    break;
                case 2: 
                    if(!st.isEmpty()) sb.append(st.pop()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case 3:
                    sb.append(st.size()).append("\n");
                    break;
                case 4:
                    if(st.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case 5:
                    if(!st.isEmpty()) sb.append(st.peek()).append("\n");
                    else sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
