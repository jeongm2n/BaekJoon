import java.util.Scanner;

public class Q5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] array = new int[30];
        for(int i=0; i<30; i++){
            array[i] = 0;
        }

        for(int i=0; i<28; i++){
            int n = sc.nextInt();
            array[n-1] = n;
        }

        for(int i=0; i<30; i++){
            if(array[i]==0){
                System.out.println(i+1);
            }
        }
    }   
}
