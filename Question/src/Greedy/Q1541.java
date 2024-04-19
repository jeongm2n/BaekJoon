package Greedy;
import java.util.*;

public class Q1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();

        String[] minus = s.split("-");
        int sum = Integer.MAX_VALUE;
        for(String m : minus){
            int tmp = 0;
            String[] plus = m.split("\\+");
            for(String p : plus){
                tmp += Integer.parseInt(p);
            }
            if(sum==Integer.MAX_VALUE){
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
