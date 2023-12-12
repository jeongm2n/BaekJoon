import java.util.*;

public class Q10926 {
    public static void main(String[] args) {
        String str1;

        Scanner sc = new Scanner(System.in);
        str1 = sc.next();
        
        String str2 = str1;
        
        if(str1.equals(str2)){
            str1 += "??!";
        }
        System.out.println(str1);
    }
}
