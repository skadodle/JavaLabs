import java.util.Iterator;

public class testMyList {
    public static void main(String[] args) {
        myList<Integer> list = new myList<Integer>();
        list.pushForward(5);
        list.pushForward(11);
        list.pushBack(9);

        list.printList();
        System.out.println("SIZE = " + list.getSize());
        
        try { list.delete(5); }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        list.printList();
        System.out.println("SIZE = " + list.getSize());

        list.pushForward(1112);
        list.pushForward(911);
        list.pushBack(52);

        list.printList();
        System.out.println("SIZE = " + list.getSize());

        try {
            System.out.println("POP BACK = " + list.popBack());
            System.out.println("POP FORWARD = " + list.popForward());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Iterator: ");
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        System.out.println("List after popping first and last");
        list.printList();
        System.out.println("SIZE = " + list.getSize());

        list.clear();
        System.out.println("SIZE AFTER CLEARING = " + list.getSize());
        
        // test ITERATOR
        main2();
        main3();
    }

    public static void main2() {
        myList<Integer> list = new myList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        System.out.println("Iterator from beginning: ");
        Iterator<Integer> iterBegin = list.iteratorBegin();
        while (iterBegin.hasNext()) {
            System.out.print(iterBegin.next() + " ");
        }
        System.out.println();

        System.out.println("Iterator from end: ");
        Iterator<Integer> iterEnd = list.iteratorEnd();
        while (iterEnd.hasNext()) {
            System.out.print(iterEnd.next() + " ");
        }
        System.out.println();
        iterEnd = list.iteratorBegin();
        while (iterEnd.hasNext()) {
            System.out.print(iterEnd.next() + " ");
        }
        System.out.println();
    }

    public static void main3() {
        myList<Integer> list = new myList<>();
        for (int i = 0; i < 50; i++) {
            list.pushBack((int) Math.round(Math.random() * 256));
        }

        list.printList();
        simpleSort.bubbleSort(list);
        list.printList();
    }
}
