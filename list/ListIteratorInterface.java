package list;

public interface ListIteratorInterface<E>
{
    boolean hasNext();
    boolean hasPrevious();
    E next() throws Exception;
    E previous() throws Exception;
    void add(E data);
    void remove() throws Exception;
    void set(E data) throws Exception;
}