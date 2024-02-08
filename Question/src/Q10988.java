import java.util.Scanner;

public class Q10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String reversed = new StringBuilder(str).reverse().toString();

        if(str.equals(reversed)){
            System.out.print("1");
        }
        else{
            System.out.print("0");
        }
    }
}
