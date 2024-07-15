package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2224 {
    static boolean[][] dist;

    static int chk(char c){
        if(c>='A' && c<='Z') return c-65;
        return c-71;
    }

    static char chk2(int a){
        if(a<26) return (char)(a+65);
        return (char)(a+71);
    }

    static void floyd(){
        for(int k=0; k<52; k++){
            for(int i=0; i<52; i++){
                for(int j=0; j<52; j++){
                    if(i==j || i==k || k==j) continue;
                    if(dist[i][k] && dist[k][j]) dist[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        dist = new boolean[52][52];

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");

            int s = chk(str[0].charAt(0));
            int e = chk(str[2].charAt(0));

            dist[s][e] = true;
        }

        floyd();

        StringBuilder sb = new StringBuilder();

        int cnt=0;

        for(int i=0; i<52; i++){
            for(int j=0; j<52; j++){
                if(dist[i][j] && i!=j){
                    cnt++;
                    char c1 = chk2(i);
                    char c2 = chk2(j);

                    sb.append(c1 + " => " + c2).append("\n");
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
