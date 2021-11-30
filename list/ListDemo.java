package list;

public class ListDemo
{
    public static void main(String[] args)
    {
        
        try
        {
        
        List<String> list = new List();
        list.addLast("Juliet");
        System.out.println("Juliet added to list");
        list.addLast("Bob");
        System.out.println("Bob added to list");
        list.addFirst("Tom");
        System.out.println("Tom added to list");
        list.addFirst("Mary");
        System.out.println("Mary added to list");
        System.out.println("list = " + list);
        System.out.println(list.removeFirst() + " removed from list");
        System.out.println(list.removeLast() + " removed from list");
        System.out.println("list = " + list);
        // | in the comments indicates the iterator position
        ListIteratorInterface<String> iterator = list.listIterator(); // |TJ
        System.out.println("Iterator is at beginning of list");
        iterator.add("Diana");  // D|TJ
        System.out.println("Diana added to list");
        
        System.out.println("list = " + list);
        System.out.println("Iterator passed " + iterator.next());  // DT|J
        System.out.println("Iterator passed " + iterator.next());  // DTJ|
        iterator.add("Harry");  // DTJH|
        System.out.println("Harry added to list");
        System.out.println("list = " + list);
        iterator = list.listIterator();  // |DTJH
        System.out.println("Iterator moved to beginning of list");
        System.out.println("Iterator passed " + iterator.next());  // D|TJH
        System.out.println("Iterator passed " + iterator.next());  // DT|JH
        // Add more nodes after second node
        iterator.add("Nina");  // DTN|JH
        System.out.println("Nina added to list");
        iterator.add("Romeo");  //DTNR|JH
        System.out.println("Romeo added to list");
        System.out.println("list = " + list);
        String name = iterator.next();
        System.out.println("Iterator passed " + name); // DTNRJ|H
        // Remove last traversed element
        iterator.remove(); // DTNR|H
        System.out.println(name + " removed from list");
        System.out.println("list = " + list);
        System.out.println("Iterator passed " + iterator.previous());//DTN|RH
        System.out.println("Iterator passed " + iterator.previous());//DT|NRH
        name = iterator.previous();
        System.out.println("Iterator passed " + name);  // D|TNRH
        // Remove last traversed element
        iterator.remove();  // D|NRH
        System.out.println(name + " removed from list");
        System.out.println("list = " + list);
        iterator = list.listIterator();  // |DNRH
        System.out.println("Iterator moved to beginning of list");
        System.out.println();
        // Print all elements backward and forward
        System.out.println("Forward version of list:");
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println();
        System.out.println("Backward version of list:");
        while (iterator.hasPrevious())
            System.out.println(iterator.previous());
        System.out.println();
        System.out.println("Iterator is at beginning of list"); // |DNRH 
        System.out.println("Iterator passed " + iterator.next()); // D|NRH
        iterator.add("Sara");  // DS|NRH
        System.out.println("Sara added to list");
        System.out.println("list = " + list);
        System.out.println("Try to remove Sara from list: ");
        iterator.remove();
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}