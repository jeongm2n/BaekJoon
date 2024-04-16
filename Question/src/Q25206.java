import java.util.*;

public class Q25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> map = new HashMap<>();
        map.put("A+",4.5);
        map.put("A0",4.0);
        map.put("B+",3.5);
        map.put("B0",3.0);
        map.put("C+",2.5);
        map.put("C0",2.0);
        map.put("D+",1.5);
        map.put("D0",1.0);
        map.put("F",0.0);

        double msum = 0;
        double sum = 0;

        for(int i=0; i<20; i++){
            String[] splits = sc.nextLine().split(" ");
            if(splits[2].equals("P")){
                continue;
            }
            double mine = Double.parseDouble(splits[1]);
            double avg = map.get(splits[2]);
            sum += mine;
            msum += mine*avg;
        }

        double result = msum/sum;
        System.out.printf("%.6f\n", result);
    }
}
