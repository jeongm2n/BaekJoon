import java.util.Scanner;

public class Q10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for(int a=0; a<n; a++){
            array[a] = a+1;
        }

        for(int a=0; a<m; a++){
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;

            while(i<j){
                int temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        }
        
        for(int i=0; i<n; i++){
            System.out.print(array[i] + " ");
        }
    }    
}
