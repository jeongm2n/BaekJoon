package Greedy;

import java.util.*;

public class Q14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int charge = sc.nextInt();
        int result = 0;

        while(charge>0){
            if(charge%5 == 0){
                result += charge/5;
                break;
            }

            charge -= 2;
            result++;
        }

        if(charge<0) result = -1;
        System.out.println(result);
    }
}
