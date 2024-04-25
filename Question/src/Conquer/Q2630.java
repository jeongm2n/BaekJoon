package Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {
    static int[][] graph;
    static int blue;
    static int white;

    static boolean check(int row, int col, int size){
        int color = graph[col][row];

        for(int i=0; i<col+size; i++){
            for(int j=0; j<row+size; j++){
                if(graph[i][j]!=color) return false;
            }
        }
        return true;
    }

    static void conquer(int row, int col, int size){
        if(check(row,col,size)){
            if(graph[col][row]==0) white++;
            else blue++;
            return;
        }

        int nsize = size/2;

        conquer(row,col,nsize); //2사분면
        conquer(row,col+nsize,nsize); //1사분면
        conquer(row+nsize,col,nsize); //3사분면
        conquer(row+nsize,col+nsize,nsize); //4사분면
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        blue=0; white=0;

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        conquer(0,0,n);
        
        System.out.println(white);
        System.out.println(blue);
    }
}
