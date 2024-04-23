package Binary;

import java.util.Scanner;

public class Q1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int min = 1;
        int max = k;
        int result = 0;

        while(min<=max){
            int mid = (min+max)/2;
            long cnt = 0;

            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            }
            
            if(cnt < k) min = mid + 1;
            else{
                max = mid-1;
                result = mid;
            }
        }
        System.out.println(result);
    }   
}
