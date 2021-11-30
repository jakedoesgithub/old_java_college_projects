package binarysearchtree;

public class BinarySearchTreeDemo 
{
    public static void main(String[] args)
    {
        BinarySearchTree<Character> tree = new BinarySearchTree();
        tree.insertItem('W');  tree.insertItem('H');  tree.insertItem('X');
        tree.insertItem('A');  tree.insertItem('S');  tree.insertItem('Y');
        tree.insertItem('D');  tree.insertItem('L');  tree.insertItem('T');
        tree.insertItem('C');  tree.insertItem('F');  tree.insertItem('I');
        tree.insertItem('M');  tree.insertItem('B');  tree.insertItem('E');
        tree.insertItem('G');  tree.insertItem('K');  tree.insertItem('P');
        tree.insertItem('J');  tree.insertItem('N');  tree.insertItem('R');
        System.out.println("Initial tree:      ");  tree.printTree();
        tree.removeItem('H');
        System.out.println("H removed");  tree.printTree();
        tree.removeItem('C');
        System.out.println("C removed");  tree.printTree();
        tree.removeItem('T');
        System.out.println("T removed");  tree.printTree();
        tree.removeItem('S');
        System.out.println("S removed");  tree.printTree();
        tree.removeItem('X');
        System.out.println("X removed");  tree.printTree();
        tree.removeItem('D');
        System.out.println("D removed");  tree.printTree();
        tree.removeItem('E');
        System.out.println("E removed");  tree.printTree();
        tree.removeItem('Y');
        System.out.println("Y removed");  tree.printTree();
        tree.removeItem('W');
        System.out.println("W removed");  tree.printTree();
        tree.removeItem('L');
        System.out.println("L removed");  tree.printTree();
        tree.removeItem('I');
        System.out.println("I removed");  tree.printTree();
        tree.removeItem('M');
        System.out.println("M removed");  tree.printTree();    
    }
}
