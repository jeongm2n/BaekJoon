import java.util.Scanner;

public class Q2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt()*2-1;
        int mid = n/2;
        int tmp = 0;

        for(int i=1; i<=mid+1; i++){
            for(int j=0; j<=n; j++){
                if(j>=mid-tmp && j<=mid+tmp){
                    System.out.print("*");
                }
                else{
                    if(j > mid+tmp){
                        break;
                    }
                    System.out.print(" ");
                }
            }
            System.out.println();
            tmp+=1;
        }
        tmp-=1;
        
        for(int i=mid+1; i<n; i++){
            tmp-=1;
            for(int j=0; j<=n; j++){
                if(j>=mid-tmp && j<=mid+tmp){
                    System.out.print("*");
                }
                else{
                    if(j > mid+tmp){
                        break;
                    }
                    System.out.print(" ");
                }
            }
            if(i<n){System.out.println();}
        }
    }
}