package binarysearchtree3;

public class BinarySearchTree3Demo 
{
    public static void main(String[] args)
    {
        BinarySearchTree3<Character> tree = new BinarySearchTree3();
               
        tree.insertItem('W');  tree.insertItem('I');  tree.insertItem('X');
        tree.insertItem('A');  tree.insertItem('S');  tree.insertItem('Y');
        tree.insertItem('E');  tree.insertItem('M');  tree.insertItem('T');
        tree.insertItem('C');  tree.insertItem('D');  tree.insertItem('G');  
        tree.insertItem('J');
        tree.insertItem('N');  tree.insertItem('B');  tree.insertItem('F');
        tree.insertItem('H');  tree.insertItem('L');  tree.insertItem('P');
        tree.insertItem('K');  tree.insertItem('O');  tree.insertItem('R');                
        
        System.out.println("Initial tree:      ");  tree.printTreeInOrder();
        tree.printTreeInPreOrder();
        tree.printTreeInPostOrder();
        tree.printHeight();
        tree.printTreeInLevelOrder();
        if(tree.isFullTree('M'))
            System.out.println("Subtree rooted at M is full");
        else
            System.out.println("Subtree rooted at M is not full");
        if(tree.isPerfectTree('M'))
            System.out.println("Subtree rooted at M is perfect");
        else
            System.out.println("Subtree rooted at M is not perfect");
        if(tree.isFullTree('E'))
            System.out.println("Subtree rooted at E is full");
        else
            System.out.println("Subtree rooted at E is not full");
        if(tree.isPerfectTree('E'))
            System.out.println("Subtree rooted at E is perfect");
        else
            System.out.println("Subtree rooted at E is not perfect");
        System.out.println();
        tree.removeItem('B');
        System.out.println("B removed");  tree.printTreeInOrder();
        tree.removeItem('D');
        System.out.println("D removed");  tree.printTreeInOrder();
        if(tree.isFullTree('E'))
            System.out.println("Subtree rooted at E is full");
        else
            System.out.println("Subtree rooted at E is not full");
        if(tree.isPerfectTree('E'))
            System.out.println("Subtree rooted at E is perfect");
        else
            System.out.println("Subtree rooted at E is not perfect");
        System.out.println();
        tree.removeItem('H');
        System.out.println("H removed");  tree.printTreeInOrder(); 
        tree.removeItem('C');
        System.out.println("C removed");  tree.printTreeInOrder();
        tree.removeItem('T');
        System.out.println("T removed");  tree.printTreeInOrder();
        tree.removeItem('S');
        System.out.println("S removed");  tree.printTreeInOrder();
        tree.removeItem('X');
        System.out.println("X removed");  tree.printTreeInOrder();
        tree.removeItem('E');
        System.out.println("E removed");  tree.printTreeInOrder();
        tree.removeItem('Y');
        System.out.println("Y removed");  tree.printTreeInOrder();
        tree.removeItem('W');
        System.out.println("W removed");  tree.printTreeInOrder();
        tree.removeItem('L');
        System.out.println("L removed");  tree.printTreeInOrder();
        tree.removeItem('I');
        System.out.println("I removed");  tree.printTreeInOrder();
        tree.removeItem('M');
        System.out.println("M removed");  tree.printTreeInOrder();    
        tree.printTreeInPreOrder();
        tree.printTreeInPostOrder();
        tree.printHeight();
        tree.printTreeInLevelOrder();
    }
}
