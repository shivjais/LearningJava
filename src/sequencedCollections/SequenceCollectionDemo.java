package sequencedCollections;

import java.util.*;

//SequenceCollection, SequenceSet & SequenceMap are introduced in java21
//they provide common methods to get first element, last element & reversed collection to different collection types
public class SequenceCollectionDemo {
    public static void main(String[] args) {
        //follows insertion order
        List<String> list = new ArrayList<>(List.of( "b", "c","d"));
        list.addFirst("a");
        list.addLast("e");
        list.addLast("a");
        list.addLast("f");
        System.out.println("list:"+list);
        System.out.println("First Element from list: " + list.getFirst());
        System.out.println("Last Element from list: " + list.getLast());
        System.out.println("Removed Last from list: " + list.removeLast());
        System.out.println("Removed First from list: " + list.removeFirst());
        System.out.println("Reversed list: " + list.reversed());

        //Deque uses doubly ended queue internally
        //follows insertion order
        Deque<String> deque = new ArrayDeque<>(List.of("b","c","d"));
        deque.addFirst("a");
        deque.addLast("e");
        deque.addLast("a");
        deque.addLast("f");
        System.out.println("Deque: " + deque);
        System.out.println("First Element from deque: " + deque.getFirst());
        System.out.println("Last Element from deque: " + deque.getLast());
        System.out.println("Removed Last from deque: " + deque.removeLast());
        System.out.println("Removed First from deque: " + deque.removeFirst());
        System.out.println("Reversed deque: " + deque.reversed());
    }
}
