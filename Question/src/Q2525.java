import java.util.Scanner;

public class Q2525 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();

        hour += (min+time)/60;
        min = (min+time)%60;

        if(hour>=24){
            hour-=24;
        }

        System.out.println(hour+" "+min);
    }
}
