package binarysearchtree;

public interface BinarySearchTreeInterface<E extends Comparable> 
{
    int size();
    boolean isEmpty(); 
    void insertItem(E item);
    boolean inTree(E item); 
    void removeItem(E item); 
    E retrieve(E item) throws Exception; 
    void printTree(); 
} 