package Sort;

import java.io.*;
import java.util.*;

public class Q11663 {
    static int[] arr;

    private static int binarySearch(int s, int check) {
        int l = 0;
        int r = arr.length-1;

        if(check==0){
            while(l<=r){
                int mid = (l+r)/2;
                if (arr[mid] < s) l = mid+1;
                else r = mid-1;
            }
            return l;
        }
        else{
            while(l<=r){
                int mid = (l+r)/2;
                if(arr[mid]>s) r = mid-1;
                else l = mid+1;
            }
            return r+1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int sidx = binarySearch(s,0);
            int eidx = binarySearch(e,1);

            sb.append(eidx-sidx).append("\n");
        }
        System.out.println(sb);
    }
}
