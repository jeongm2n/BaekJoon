package Sort.Bubble;

import java.io.*;

public class Q1377 {
    static int[] arr;
    static int N;

    static void bubble_sort(){
        boolean changed = false;
    
        for(int i=1; i<=N+1; i++){
            changed = false;
            for(int j=1; j<=N-i; j++){
                if(arr[j]>arr[j+1]){
                    changed = true;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(!changed){
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
        
        bubble_sort();
    }
}
