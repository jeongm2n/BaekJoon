package Greedy;
import java.util.*;

public class Q1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] time = new int[n][2];

        for(int i=0; i<n; i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }
        Arrays.sort(time, (time_1, time_2)->{
            if(time_1[1]==time_2[1]) return time_1[0] - time_2[0];
            return time_1[1] - time_2[1];
        });

        int before = 0;
        int cnt = 0;
        
        for(int i=0; i<n; i++){
            if(before<=time[i][0]){
                before = time[i][1];
                cnt++;
            }    
        }
        System.out.print(cnt);
    }
}
