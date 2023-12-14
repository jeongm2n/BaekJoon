import java.util.Scanner;

public class Q10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();    
        }

        int a = sc.nextInt();
        int cnt = 0;

        for(int i=0; i<n; i++){
            if(array[i] == a){
                cnt++;
            }
        }
        System.out.println(cnt);
    }    
}
