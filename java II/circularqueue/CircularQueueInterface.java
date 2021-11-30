package circularqueue;

public interface CircularQueueInterface<E>
{
    int size();
    boolean isEmpty();
    void enqueue(E data);
    E front() throws Exception;
    E dequeue() throws Exception;
}
