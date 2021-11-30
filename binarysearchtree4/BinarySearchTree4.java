package binarysearchtree4;

public class BinarySearchTree4<E extends Comparable> 
                              implements BinarySearchTree4Interface<E>
{
    private Node root; 
    private int size;
    private boolean firstNodePrinted;
    private boolean completeTree;
    private boolean nullChildFound;
    public int numFullNodes;
    public int numHalfNodes;
    public int numLeafNodes;
    public int numNodesInLevel;
    
    private class Node 
    {
        public E data; 
        public Node left; 
        public Node right;
    } 
    
    public BinarySearchTree4() 
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
        if (topNode == null)
            return 0;
        else
        {
            int leftHeight = height(topNode.left);
            int rightHeight = height(topNode.right);
            if (leftHeight > rightHeight)
                return(leftHeight+1);
            else 
                return(rightHeight+1); 
        }
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
        if (node == null)
            return;
        if (currentLevel == printLevel)
            System.out.print(node.data + " ");
        else 
        {
            currentLevel++;
            printNodesInLevel(node.left, currentLevel, printLevel);
            printNodesInLevel(node.right, currentLevel, printLevel);
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
        if(topNode == null)
            return 0;
        else
            return sizeOfTree(topNode.left) + sizeOfTree(topNode.right) + 1; 
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
        if(topNode == null)
            return true;
        else
        {
            int h = height(topNode);
            return sizeOfTree(topNode) == Math.pow(2, h) - 1;
        }
    }
        
    public boolean isCompleteTree(E item)
    {
        int currentLevel, levelToBeChecked;
        Node topNode = search(item);
        int h = height(topNode);
        completeTree = true;
        for (levelToBeChecked = 1; levelToBeChecked <= h-1; levelToBeChecked++)
        {
            currentLevel = 1;
            nullChildFound = false;
            isComplete(topNode, currentLevel, levelToBeChecked);
        }
        return completeTree;
    }
    
    /** 
     * A recursive auxiliary method for the isCompleteTree method.  
     */ 
    private void isComplete(Node node, int currentLevel, int levelToBeChecked)
    {
        if(node == null)
            return;
        if(currentLevel == levelToBeChecked)
        {
            if(node.left != null)
            {
                if(nullChildFound)
                    completeTree = false;
            }
            else
                nullChildFound = true;
            if(node.right != null)
            {
                if(nullChildFound)
                    completeTree = false;
            }
            else
                nullChildFound = true;
        }
        else
        {
            currentLevel++;
            isComplete(node.left, currentLevel, levelToBeChecked);
            isComplete(node.right, currentLevel, levelToBeChecked);
        }           
    }
    
    public void countFullHalfAndLeafNodesInTree(E item)
    {
        Node topNode = search(item);
        numFullNodes = 0;
        numHalfNodes = 0;
        numLeafNodes = 0;
        countFullHalfAndLeafNodes(topNode);    
    }
    
    /** 
     * A recursive auxiliary method for the countFullHalfAndLeafNodesInTree
     * method.  
     */ 
    private void countFullHalfAndLeafNodes(Node topNode)
    { 
        if(topNode.left == null)
        {
            if(topNode.right == null)
            {
                numLeafNodes++;
            }
            else
            {
                numHalfNodes++;
                countFullHalfAndLeafNodes(topNode.right);
            }
        }
        else
        {
            if(topNode.right == null)
            {
                numHalfNodes++;
                countFullHalfAndLeafNodes(topNode.left);
            }
            else
            {
                numFullNodes++;
                countFullHalfAndLeafNodes(topNode.left);
                countFullHalfAndLeafNodes(topNode.right);
            }
        }
         
      
            
    }
            
    public void countNodesInLevelsOfTree()
    {
        int h = height(root);
        int level, numInLevel;
        for (level = 1; level <= h; level++)
        {
            numNodesInLevel = 0;
            countNodesInLevel(root, level);
            System.out.println("Number of nodes in level " + level + " = "
                               + numNodesInLevel);
        }
    }
    
    /** 
     * A recursive auxiliary method for the countNodesInLevelsOfTree method
     */ 
    private void countNodesInLevel(Node node ,int level)
    {
        if (level > 1)
        {
            if(node.left != null)
            {
                countNodesInLevel(node.left, level - 1);
            }
            if(node.right != null)
            {
                countNodesInLevel(node.right, level -1);
            }
        }
        else
        numNodesInLevel++;
    }    
}
