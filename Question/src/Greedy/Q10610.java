package Greedy;

import java.util.*;

public class Q10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char[] arr = str.toCharArray();

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--){
            int n = arr[i] - '0';

            sum += n;
            sb.append(n);
        }

        if(arr[0]!='0' || sum%3!=0){
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}
