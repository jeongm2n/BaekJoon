import java.util.*;

public class Q18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] before = new int[n];
        int[] sortarr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            sortarr[i] = before[i] = sc.nextInt();    
        }
        
        Arrays.sort(sortarr);
        
        int idx = 0;
        for(int i : sortarr){
            if(!map.containsKey(i)){
                map.put(i,idx);
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : before){
            sb.append(map.get(i)).append(' ');
        }
        System.out.print(sb);
    }
}
