package Dijkstra.Floyd;

import java.io.*;
import java.util.*;

public class Q11581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int N = Integer.parseInt(br.readLine());        
        boolean[][] arr = new boolean[N + 1][N + 1];    

        // 데이터 초boolean[] 기화    boolean[]     
        for (int i = 1; i < N; i++) {            
            int e = Integer.parseInt(br.readLine());            
            StringTokenizer st = new StringTokenizer(br.readLine());             
            for (int j = 0; j < e; j++) {                
                int num = Integer.parseInt(st.nextToken());                
                arr[i][num] = true;            
            }        
        }                
       
        for (int k = 1; k < N; k++) {            
            for (int i=1; i<N; i++) {                
                for (int j=1; j<N; j++) {                    
                    if (arr[i][k] && arr[k][j]) {                        
                        arr[i][j] = true;                    
                    }                
                }            
            }        
        }      

        String result = "NO CYCLE";                
            
        for (int i = 1; i < N; i++) {            
            if (arr[1][i] && arr[i][i]) {                
                result = "CYCLE";                
                break;            
            }        
        }

        System.out.println(result);
    }
}
