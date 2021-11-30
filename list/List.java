package list;


/**
 * 
 * @author Your name
 */
public class List<E>
{
    
    private Node first;
    private Node last;
    private int length;

    
    private class Node
    {
        public E data;
        public Node next;
        public Node prev;
    }

    
    /**
     * A generic inner ListIterator class that implements the
     * ListIteratorInterface. It is used as a cursor to traverse the list.
     */
    private class ListIterator implements ListIteratorInterface<E>
    {
        
        private Node position;  // the node on the left of the iterator
        private Node previousPosition;  // the previous iterator position
        private boolean isAfterNext;
        private boolean isAfterPrevious;

        
        /**
         * Constructs an iterator at the beginning of the linked list.
         */
        public ListIterator()                
        {
            position = null;
            previousPosition = null;
            isAfterNext = false;
            isAfterPrevious = false;
        }

        
        /**
         * Returns true if there is a node on the right of the iterator;
         * otherwise, returns false.
         */    
        public boolean hasNext()
        {
            if (position == null)
                return first != null;
            else
                return position.next != null;
        }

        
        /**
         * Returns true if there is a node on the left of the iterator;
         * otherwise, returns false.
         */    
        public boolean hasPrevious()
        {
            if(position == null)
                    return false;
            else
                return true;
                    
            
        }

        
        /**
         * Resets the iterator's previousPosition to its current position, 
         * resets the iterator's current position to the node on the right
         * of its current position (moves the iterator, in the forward 
         * direction, past the node on the right), and returns the data 
         * value in the node that the iterator just passed over.
         * Throws an exception if the iterator is at the end of the list.
         */        
        public E next() throws Exception
        {
            if (!hasNext())
                throw new Exception("Called at the end of the list");
            previousPosition = position;  // Remember for remove.
            if (position == null)
                position = first;
            else
                position = position.next;
            
            isAfterNext = true;
            return position.data;
        }

        
        /**
         * Resets the iterator's previousPosition to its current position, 
         * resets the iterator's current position to the node on the left 
         * of its current position (moves the iterator, in the backward 
         * direction, past the node on the left), and returns the data 
         * value in the node that the iterator just passed over.
         * Throws an exception if the iterator is at the beginning of the 
         * list.
         */
        public E previous() throws Exception
        {
            E data = position.data;
            if (!hasPrevious())
                throw new Exception("Called at beginning of list");
            previousPosition = position; // remember for remove
            if(position == null)
            {
                position = last;
            }
            else
            {
                position = position.prev;
            }     
            isAfterPrevious = true;
            return data;
        }
        
        /**
         * Inserts a new node on the left of the iterator and resets
         * the iterator position to this inserted node.
         */
        public void add(E data)
        {
            if (position == null)
            {
                addFirst(data);
                position = first;
            }
            else if(position.next == null)
            {
                addLast(data);
                position = last;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = position.next;
                position.next.prev = newNode;
                newNode.prev = position;
                position.next = newNode;
                position = newNode;
                length++;
            }
            isAfterNext = false;
            isAfterPrevious = false;
        }

        
        /**
         * Removes the last node passed over by the iterator in a call to
         * either next or previous.
         * Throws an exception if remove is not called immediately after a
         * call to either next or previous.
        */
        public void remove() throws Exception
        {
            if(!isAfterNext && !isAfterPrevious)
                throw new Exception("remove not called immediatly after next or previous");
            
            if(isAfterNext)
            {
                previousPosition.next = position.next;
                position.next.prev = previousPosition;
                
            }
            else
            {
                previousPosition.prev = position.prev;
                position.prev.next = previousPosition;
               
            }
            length --;
            isAfterNext = false;
            isAfterPrevious = false;
            previousPosition = null;
            
            
            
            
        }

        
        /**
         * Replaces the data value in the node on the left of the iterator
         * with the input data value.
         * Throws an exception if the node on the left of the iterator is
         * null.
         */
        public void set(E data) throws Exception
        {
            if (position == null)
                throw new Exception("set call on a null node");
            position.data = data;
        }        
    }

    
    // Constructs an empty linked list.
    public List()
    {
        first = null;
        last = null;
        length = 0;
    }

    
    /**
     * Returns the number of elements in the linked list.
     */
    public int size()
    {
        return length;
    }

    
    /**
     * Adds a new node at the beginning of the linked list.
     */
    public void addFirst(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if(length == 0)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        length++;
    }

    
    /**
     * Adds a new node at the end of the linked list.
     */
    public void addLast(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if (length == 0)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        length ++;
        
    }

    
    /**
     * Removes the first node in the linked list and returns this node's
     * data value.
     * Throws an exception if the list is empty.
     */
    public E removeFirst() throws Exception
    {
        if(length == 0)
            throw new Exception("Non-empty list expected");
        E data = first.data;
        if(length == 1)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
            first.prev = null;
        }
        length--;
        return data;        
    }

    
    /**
     * Removes the last node in the linked list and returns this node's
     * data value.
     * Throws an exception if the list is empty.
     */
    public E removeLast() throws Exception
    {
        if(length == 0)
            throw new Exception("Non-empty list expected");
        E data = last.data;
        if(length == 1)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.prev;
            last.next = null;
        }
        length --;
        return data;
    }
    
    /**
     * Returns the data value in the first node of the linked list.
     * Throws an exception if the list is empty.
     */
    public E getFirst() throws Exception
    {
        if (first == null)
            throw new Exception("Non-empty list expected");
        return first.data;
    }

    
    /**
     * Returns an iterator for iterating through the linked list.
     */
    public ListIterator listIterator()
    {
        return new ListIterator();
    }

    
    /**
     * @return a string representation of the elements of the linked list
     * in the format [e0, e1, ..., en-2, en-1], where each ei is a data 
     * value in the list and e0 is the data value in the first node 
     * and en-1 is the data value in the last node. It returns [] if this 
     * list is empty.
     */	 
    public String toString()
    {
       String string = "[";
       if(length > 0)
       {
           Node node = first;
           string += node.data;
           while(node != last)
           {
               node = node.next;
               string += ", " + node.data;
           }           
       }
       string += "]";
       return string;
    }	    
}