import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testMyList {

    static myList<Integer> list = new myList<Integer>();

    @BeforeEach
    public void before() {
        list.clear();
        list.pushForward(5);
        list.pushForward(11);
        list.pushBack(9);
    }

    @Test 
    public void testCase1() {
        Assertions.assertEquals(3, list.getSize());
    }

    @Test 
    public void testCase2() {
        try { list.delete(5); }
        catch (Exception ex) { ex.printStackTrace(); }
        Assertions.assertEquals(2, list.getSize());
    }

    @Test 
    public void testCase3() {
        list.pushForward(1112);
        list.pushForward(911);
        list.pushBack(52);
        Assertions.assertEquals(6, list.getSize());
    }

    @Test
    public void testCase4() {
        try {
            System.out.println("POP BACK = " + list.popBack());
            System.out.println("POP FORWARD = " + list.popForward());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void testCase5() {
        list.clear();
        Assertions.assertEquals(0, list.getSize());
        System.out.println("SIZE AFTER CLEARING = " + list.getSize());
    }

    public static void main(String[] args) {
        list.pushForward(5);
        list.pushForward(11);
        list.pushBack(9);

        list.printList();
        System.out.println("SIZE = " + list.getSize());
        
        try { list.delete(5); }
        catch (Exception ex) { ex.printStackTrace(); }

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

        System.out.println("List after popping first and last");
        list.printList();
        System.out.println("SIZE = " + list.getSize());

        list.clear();
        System.out.println("SIZE AFTER CLEARING = " + list.getSize());
    }
}
