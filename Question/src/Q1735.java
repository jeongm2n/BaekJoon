import java.io.IOException;
import java.util.Scanner;

public class Q1735 {
    public static int gcd(int num1, int num2){
        if(num2>num1){
            int tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        if(num1%num2==0) return num2;
        else return gcd(num2,num1%num2);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int top = (a*d) + (c*b);
        int bottom = b*d;

        int mod = gcd(top,bottom);
        top /= mod;
        bottom /= mod;

        System.out.println(top + " " + bottom);
    }
}
