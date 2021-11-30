package binarysearchtree3;

/**
 * 
 * @author Jake Ardoin
 */
public class BinarySearchTree3<E extends Comparable> 
                              implements BinarySearchTree3Interface<E>
{
    private Node root; 
    private int size;
    private boolean firstNodePrinted;
    
    private class Node 
    {
        public E data; 
        public Node left; 
        public Node right;
    } 
    
    public BinarySearchTree3() 
    { 
        root = null; 
        size = 0; 
        firstNodePrinted = false;
    } 
    
    public int size() 
    { 
        return size; 
    }
    
    public boolean isEmpty() 
    { 
        return size == 0; 
    }
    
    public void insertItem(E item) 
    { 
        Node newNode = new Node(); 
        newNode.data = item; 
        if (size == 0) 
        { 
            root = newNode; 
            size++; 
        } 
        else 
        { 
            Node node = root; 
            while (true) 
            { 
                int d = item.compareTo(node.data); 
                if (d==0) 
                    return; 
                else if (d<0) 
                { 
                    if (node.left == null) 
                    {  
                        node.left = newNode; 
                        size++; 
                        return; 
                    } 
                    else 
                        node = node.left; 
                } 
                else 
                { 
                    if (node.right == null) 
                    {
                        node.right = newNode; 
                        size++; 
                        return; 
                    } 
                    else 
                        node = node.right; 
                } 
            } 
        } 
    }
    
    private Node search(E key) 
    { 
        Node node = root; 
        while (node != null) 
        { 
            int d = key.compareTo(node.data); 
            if (d == 0) 
                return node; 
            else if (d < 0) 
                node = node.left; 
            else 
                node = node.right; 
        } 
        return null; 
    }

    public boolean inTree(E item) 
    { 
        return search(item) != null; 
    }
    
    public E retrieve(E item) throws Exception 
    {
        if (size == 0) 
            throw new Exception("Non-empty tree expected.");
        Node node = search(item); 
        if (node == null) 
            throw new Exception("Item expected to be in tree.");
        return node.data; 
    }

    private Node findParent(Node node) 
    { 
        Node tempNode = root; 
        if (node == tempNode) 
            return null; 
        while(true) 
        { 
            if (node.data.compareTo(tempNode.data)<0) 
            { 
                if (node == tempNode.left) 
                    return tempNode; 
                tempNode = tempNode.left; 
            } 
            else 
            {
                if (node == tempNode.right) 
                    return tempNode; 
                tempNode = tempNode.right; 
            } 
        } 
    }
    
    public void removeItem(E item)
    {
        Node node = search(item);
        if (node != null)
        {
            remove(node);
            size--;
        }
    }
    
    /** 
     * A recursive auxiliary method for the removeItem method  
     */ 
    private void remove(Node node)
    {
        Node parent, replacementNode, NodeWithReplacementData;
        E replacementData;
        parent = findParent(node);
        if (node.left != null)
        {
            if (node.right != null)
            {
                NodeWithReplacementData = node.right;
                while (NodeWithReplacementData.left != null)
                    NodeWithReplacementData = NodeWithReplacementData.left;
                replacementData = NodeWithReplacementData.data;
                remove(NodeWithReplacementData);
                node.data = replacementData;
                return;
            }
            else
                replacementNode = node.left;
        }
        else
        {
            if (node.right != null)
                replacementNode = node.right;
            else
                replacementNode = null;
        }
        if (parent==null)
            root = replacementNode;
        else if (parent.left == node)
            parent.left = replacementNode;
        else
            parent.right = replacementNode;
    }

    public void printTreeInOrder() 
    {
        firstNodePrinted = true;
        System.out.println("root = " + root.data);
        System.out.print("tree in order      = [");
        printInOrder(root);
        System.out.println("]");
    }

    /** 
     * A recursive auxiliary method for the printTreeInOrder method  
     */ 
    private void printInOrder(Node node) 
    { 
        if (node != null) 
        { 
            printInOrder(node.left);
            if(firstNodePrinted)
            {
                System.out.print(node.data);
                firstNodePrinted = false;
            }
            else
                System.out.print(", " + node.data);
            printInOrder(node.right); 
        }
    }

    public void printTreeInPreOrder() 
    {
        firstNodePrinted = true;
        System.out.print("tree in pre-order  = [");
        printInPreOrder(root);
        System.out.println("]");
    }

    /** 
     * A recursive auxiliary method for the printTreeInPreOrder method  
     */ 
    private void printInPreOrder(Node node) 
    { 
        if (node != null) 
        { 
             if(firstNodePrinted)
            {
                System.out.print(node.data);
                firstNodePrinted = false;
            }
            else
                System.out.print(", " + node.data);
            printInPreOrder(node.left);
            printInPreOrder(node.right); 
        }
    }

    public void printTreeInPostOrder() 
    {
        firstNodePrinted = true;
        System.out.print("tree in post-order = [");
        printInPostOrder(root);
        System.out.println("]");
    }

    /** 
     * A recursive auxiliary method for the printTreeInPostOrder method  
     */ 
    private void printInPostOrder(Node node) 
    { 
        if (node != null) 
        { 
            printInPostOrder(node.left);
            printInPostOrder(node.right); 
             if(firstNodePrinted)
            {
                System.out.print(node.data);
                firstNodePrinted = false;
            }
            else
                System.out.print(", " + node.data);
        }
    }
    
    public void printHeight()
    {
        System.out.println("height = " + height(root));
    }

    /** 
     * A recursive auxiliary method for the printHeight method.
     * It computes the "height" of a subtree -- the number of
     * nodes along the longest path from the top node of the
     * subtree down to the farthest leaf node. 
     */ 
    private int height(Node topNode)
    {
       if(topNode == null)
           return 0;
       int lefth = height(topNode.left);
       int righth = height(topNode.right);
       
       if(lefth > righth)
           return lefth + 1;
       else
           return righth + 1;
       
            
    }    

    public void printTreeInLevelOrder()
    {
        int currentLevel, printLevel;
        int h = height(root);
        System.out.println("tree in level order:");
        for (printLevel = 1; printLevel <= h; printLevel++)
        {
            currentLevel = 1;
            printNodesInLevel(root, currentLevel, printLevel);
            System.out.println();
        }
    }
    
    /** 
     * A recursive auxiliary method for the printTreeInLevelOrder method.
     * It prints the nodes in the level denoted as printLevel.
     */ 
    private void printNodesInLevel(Node node,int currentLevel,int printLevel)
    {
        if(currentLevel == printLevel)
            System.out.print(node.data + " ");
        else if (currentLevel < printLevel)
        {
            if( node.left != null)
                printNodesInLevel(node.left, currentLevel + 1, printLevel);
            if(node.right != null)
                printNodesInLevel(node.right, currentLevel +1, printLevel);
        }
        
    }
    
    public boolean isFullTree(E item)
    {
        Node topNode = search(item);
        return isFull(topNode);    
    }
    
    /** 
     * A recursive auxiliary method for the isFullTree method.  
     * It returns true if the subtree rooted at topNode is full,
     * otherwise it returns false.
     */ 
    private boolean isFull(Node topNode)
    {
        if(topNode == null)
            return true;
        else if(topNode.left == null && topNode.right == null)
            return true;
        else if(topNode.left != null && topNode.right != null)
            return isFull(topNode.left) && isFull(topNode.right);
        else
            return false;
    }
    
    /**
     * Recursively determines the size (number of nodes) in the subtree
     * rooted at topNode
     */
    public int sizeOfTree(Node topNode) 
    {
        int subSize = 1;
        if (topNode.left != null)
           subSize += sizeOfTree(topNode.left);
        if(topNode.left != null)
            subSize += sizeOfTree(topNode.right);
        return subSize;
            
    }
    
    public boolean isPerfectTree(E item)
    {
        Node topNode = search(item);
        return isPerfect(topNode);    
    }
    
    /** 
     * An auxiliary method for the isPerfectTree method.  
     * It returns true if the subtree rooted at topNode is perfect,
     * otherwise it returns false.
     */ 
    private boolean isPerfect(Node topNode)
    {
        return (sizeOfTree(topNode) == Math.pow(2, height(topNode))-1);
    }    
}
