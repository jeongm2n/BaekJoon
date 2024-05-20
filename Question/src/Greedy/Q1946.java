package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int z=0; z<T; z++){
            int n = Integer.parseInt(br.readLine());
        
            int[][] p = new int[n][2];

            StringTokenizer st;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());

                p[i][0] = Integer.parseInt(st.nextToken());
                p[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(p, (o1,o2)->{
                return o1[0] - o2[0];
            });

            int top = p[0][1];
            int num = 0;

            for(int i=1; i<n; i++){
                if(top<p[i][1]){
                    num++;
                    continue;
                }
                top = p[i][1];
            }

            sb.append(n-num).append("\n");
        }

        System.out.println(sb);
    }
}
