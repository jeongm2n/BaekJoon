import java.util.Scanner;

public class Q10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = i+1;
        }

        for(int i=0; i<m; i++){
            int temp = 0;
            int j = sc.nextInt();
            int k = sc.nextInt();

            temp = array[j-1];
            array[j-1] = array[k-1];
            array[k-1] = temp;
        }
        
        for(int i=0; i<n; i++){
            System.out.print(array[i]+" ");
        }
    }    
}
