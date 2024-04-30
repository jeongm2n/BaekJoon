package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5639 {
    static class Node{
        int val;
        Node l;
        Node r;
        public Node(int val){
            this.val = val;
            this.l = null;
            this.r = null;
        }

        /*public void insertNode(int val){
            if(this.val > val){
                if(this.l == null) this.l = new Node(val);
                else this.l.insertNode(val);
            }else{
                if(this.r == null) this.r = new Node(val);
                else this.r.insertNode(val);
            }
        }*/
    }
    static int first;
    static Node root;
    static StringBuilder sb = new StringBuilder();

    static void postorder(Node node){
        if(node==null) return;
        postorder(node.l);
        postorder(node.r);
        sb.append(node.val).append("\n");
    }

    static void insertNode(Node parent, int val){
        if(parent.val>val){
            if(parent.l==null) parent.l = new Node(val);
            else insertNode(parent.l, val);
        }else{
            if(parent.r==null) parent.r = new Node(val);
            else insertNode(parent.r, val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        root = new Node(first);

        while(true){
            String str = br.readLine();
            if(str==null) break;
            int n = Integer.parseInt(str);

            insertNode(root, n);
        }

        postorder(root);
        System.out.println(sb);
    }
}
