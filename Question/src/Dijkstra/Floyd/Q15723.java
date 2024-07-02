package Dijkstra.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15723 {
    static int[][] graph;
    static final int INF = 100001;

    static void floyd(){
        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new int[26][26];

        for(int i=0; i<26; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);

            graph[a-'a'][b-'a'] = 1;
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        floyd();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);

            if(graph[a-'a'][b-'a']!=0 && graph[a-'a'][b-'a']!=INF) sb.append("T").append("\n");
            else sb.append("F").append("\n");
        }

        System.out.println(sb);
    }
}
