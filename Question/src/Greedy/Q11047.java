package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int[] moneys = new int[n];

        for(int i=0; i<n; i++){
            moneys[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;

        for(int i=n-1; i>=0; i--){
            if(money/moneys[i] > 0){
                cnt += money/moneys[i];
                money %= moneys[i];
            }
        }

        System.out.println(cnt);
    }
}
