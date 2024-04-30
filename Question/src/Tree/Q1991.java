package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {
    static class Node{
        char val;
        Node left;
        Node right;
        public Node(char val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Node root = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    static void insertNode(Node parent, char val, char left, char right){
        if(parent.val==val){
            parent.left = left=='.' ? null : new Node(left, null, null);
            parent.right = right=='.' ? null : new Node(right, null, null);
        }else{
            if(parent.left!=null) insertNode(parent.left, val, left, right);
            if(parent.right!=null) insertNode(parent.right, val, left, right);
        }
    }

    static void preorder(Node node){
        if(node==null) return;
        sb.append(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node){
        if(node==null) return;
        inorder(node.left);
        sb.append(node.val);
        inorder(node.right);
    }

    static void postorder(Node node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(root, parent, left, right);
        }

        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);
        sb.append("\n");

        System.out.println(sb);
    }
}
