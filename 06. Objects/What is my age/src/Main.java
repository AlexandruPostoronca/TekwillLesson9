public class Main {
    public static void main(String[] args) {
        // Write your solution here
        Tree tree1 =  new Tree();
        Tree tree2 = tree1;
        Tree tree3 = tree2;


        tree1 = new Tree();
        tree1.age = 5;
        tree2.age = 10;
        tree3 = null;
        System.out.println(tree1.toString());

    }
}