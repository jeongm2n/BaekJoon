package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2493 {
    static class Tower{
        int idx;
        int h;
        public Tower(int idx, int h){
            this.idx = idx;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Tower> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            while(!s.isEmpty()){
                if(s.peek().h>=arr[i]){
                    sb.append(s.peek().idx).append(" ");
                    break;
                }
                s.pop();
            }
            if(s.isEmpty()) sb.append(0).append(" ");
            s.push(new Tower(i, arr[i]));
        }
        System.out.println(sb);
    }
}
