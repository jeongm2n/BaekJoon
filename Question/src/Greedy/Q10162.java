package Greedy;

import java.io.*;

public class Q10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if(T%10!=0){
            System.out.println(-1);
            return;
        }

        int time[] = new int[3];
        time[0] = 300;
        time[1] = 60;
        time[2] = 10;

        int cnt[] = new int[3];
        for(int i=0; i<3; i++){
            cnt[i] = T/time[i];
            T = T%time[i];
        }

        for(int i : cnt){
            System.out.print(i + " ");
        }
    }
}
