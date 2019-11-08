package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import ua.edu.ucu.collections.Queue;
import ua.edu.ucu.collections.Stack;

public class Main {
    public static void main(String[] args) {
//        ImmutableList list = new ImmutableArrayList();
//        ImmutableList list1 = list.addAll(new Integer[] {2, 3, 4, 5, 7});
//       ImmutableList list2 = list1.addAll(1, new Integer[] {9, 1});
//        ImmutableList list3 = list.add(3).add(4).add(5).add(1, 6);
//        System.out.println(list2.clear().toString());
//        System.out.println("11" + Arrays.toString(list3.toArray()));
//        System.out.println(Arrays.toString(list1.toArray()));
//        System.out.println(list1.indexOf(3));
        ImmutableLinkedList lst = new ImmutableLinkedList(new Integer[] {1, 2, 3, 4});
        System.out.println(lst.toString());
        ImmutableLinkedList lst1 = lst.addAll(0, new Integer[] {1, 2, 3, 4, 5});
//        lst1 = lst1.remove(4);
//        lst1= lst1.set(2, 3);
//        lst1 = lst1.addFirst(2);
//        System.out.println(lst1.indexOf(4));
//        System.out.println(lst1.indexOf(6));
        lst1 = lst1.removeFirst();
        lst1 = lst1.removeLast();
        System.out.println(lst1.toString());

        Stack a = new Stack();
        a.push(1);
        System.out.println(a.toString());
        Stack b = new Stack(new Integer[] {1, 2, 3, 4});
        b.pop();
        System.out.println(b.toString());


        Queue que = new Queue();
        que.enqueue(1);
        System.out.println(que.toString());
        Queue que2 = new Queue(new Integer[] {1, 2, 3, 4});
        que2.dequeue();
        System.out.println(que2.toString());

    }
}
