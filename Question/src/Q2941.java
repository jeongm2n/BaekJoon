import java.util.Scanner;

public class Q2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        String str = sc.nextLine();

        for(int i=0; i<str.length(); i++){
            if(str.contains(array[i])){
                str = str.replace(array[i],"!");
            }
        }
        System.out.print(str.length());
    }
}
