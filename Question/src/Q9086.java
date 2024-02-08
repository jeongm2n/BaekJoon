import java.util.Scanner;

public class Q9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr[] = new String[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }

        for(int i=0; i<n; i++){
            int r = arr[i].length();
            char first = arr[i].charAt(0);
            char last = arr[i].charAt(r-1);
            System.out.print(first);
            System.out.println(last);
        }
    }
}
