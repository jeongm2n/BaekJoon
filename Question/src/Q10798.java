import java.util.Scanner;

public class Q10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char arr[][] = new char[5][15];
        for(int i=0; i<5; i++){
            String a = sc.next();
            for(int j=0; j<a.length(); j++){
                arr[i][j] = a.charAt(j);
            }
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] != 0){
                    System.out.print(arr[j][i]);
                }
            }
        }

    }    
}
