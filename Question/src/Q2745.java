import java.util.Scanner;

public class Q2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        int n = sc.nextInt();

        int stack = 1;
        int sum = 0;

        for(int i=str.length()-1; i>=0; i--){
            char a = str.charAt(i);

            if(a>='A' && a<='Z'){
                sum += (a-'A'+10) * stack;
            }else{
                sum += (a-'0') * stack;
            }
            stack *= n;
        }

        System.out.println(sum);
    }
}
