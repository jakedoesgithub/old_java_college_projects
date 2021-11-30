package binarysearchtree;

/**
 * 
 * @author Jake Ardoin
 */
public class BinarySearchTree<E extends Comparable> 
                             implements BinarySearchTreeInterface<E>
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
    
    public BinarySearchTree() 
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
        
        if(node == root)
        { return null;}
        
        Node temp = root;
        Node result = temp;
        while(temp != null)
        {
            if(temp.data.compareTo(node.data) == 0)
            {
                return result;
            }
            if(temp.data.compareTo(node.data) < 0)
            {
                result = temp;
                temp = temp.right;
            }
            else
            {
                result = temp;
                temp = temp.left;
            }
        }
        return temp;
                
            
              
              
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
    
    private void remove(Node node)
    {
       Node parent = findParent(node);
       // if its a leaf
       if( node.left == null && node.right == null)
       {
           if (node.data.compareTo(parent.data) < 0)
           {
               parent.left = null;
           }
           if (node.data.compareTo(parent.data) > 0)
           {
               parent.right = null;
           }
       }
       //single child
       if (node.left == null || node.right == null)
       { 
           Node hold = new Node();
           if (node.left == null)
           {
               hold = node.right;
           }
           else
           {
               hold = node.left;
           }
           
           if (parent == null)
           {
               root = hold;
           }
           else if (parent.left == node)
           {
               parent.left = hold;
           }
           else
           {
               parent.right = hold;
           }
       }
       // has two children
       if(node.left != null && node.right != null)
       {
           Node holdParent = node;
           Node hold = node.right;
           while (hold.left != null)
           {
            holdParent = hold;
            hold = hold.left;
           }
           
           node.data = hold.data;
           if (holdParent == node)
           {
               holdParent.right = hold.right;
           }
           else
           {
               holdParent.left = hold.right;
           }
       }
       
           
       
    }
   
    
    public void printTree() 
    {
        firstNodePrinted = true;
        System.out.print("root = " + root.data + ",   tree = [");
        printInOrder(root);
        System.out.println("]");
        System.out.println();
    }

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

}
