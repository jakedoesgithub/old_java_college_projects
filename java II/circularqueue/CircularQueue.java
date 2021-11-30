package circularqueue;

/**
 * 
 * Your name
 */
public class CircularQueue<E> implements CircularQueueInterface<E>
{
    private Node rear;
    private int length;

    /**
     * this inner class is used to create nodes of a singly-linked queue
     */
    private class Node
    {
       public E data;
       public Node next;
    }

    /**
     * Creates an empty singly-linked queue
     */
    public CircularQueue()
    {
        rear = null;
        length = 0;
    }
    
    public int size()
    {
        return length;
    }

    /**
     * Determines whether the queue is empty.
     * @return true if the queue is empty;
     * otherwise, false
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Inserts an item at the back of the queue.
     * @param data the value to be inserted.
     */
    public void enqueue(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if(length == 0)
        {
            rear = newNode;
            rear.next = rear;
        }    
        else
        {
            newNode.next = rear.next;
            rear.next = newNode;
            rear = newNode;
        }
        length++;
                
            
    }

    /**
     * Accesses the item at the front of a non-empty queue
     * @return item at the front of the queue.
     * @throws Exception when this queue is empty
     */
    public E front() throws Exception
    {
        if (length ==0)
            throw new Exception("Non-empty queue expected");
        return rear.next.data;
    }

    /**
     * Deletes an item from the front of the queue.
     * @return item at the front of the queue.
     * @throws Exception when this queue is empty
     */
    public E dequeue() throws Exception
    {
        if (length == 0)
            throw new Exception("Non-empty queue expected");
        if (length == 1)
        {
            E item = rear.data;
            length --;
            rear = null;
            return item;
        }
        else
        {
            E item = rear.next.data;
            rear.next = rear.next.next;
            length --;
            return item;
        }
        
    }

    
    /**
     * Moves the node at the front of the queue to the back.
     */
    public void rotateClockwise()
    {
        rear = rear.next;
    }

    /**
     * Moves the node at the back of the queue to the front.
     */
    public void rotateCounterclockwise()
    {
        Node node = new Node();
        for(int i = 1; i < length; i++)
        {
            rear = rear.next;
        }
            
    }
	
    /**
     * Returns a string [en-1, ..., e2, e1, e0] representing this queue, 
     * where e0 is the data item in the head bode and en-1 is the data item
     * in the rear node. It returns [] if this queue is empty.     
     */	 
    public String toString()
    {
        String string = "]";
        if( length != 0)
        {
            Node node = rear.next;
            string = node.data + string;
            for( int i = 1; i < length; i++)
            {
                node = node.next;
                string = node.data + ", " + string;
            }
        }
        string = "[" + string;
        return string;
    }	    
}
