import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testMyVector {
    static myVector<Integer> vector = new myVector<>(Integer.class);

    @BeforeEach
    public void before() {
        vector.clear();
        vector.pushBack(1);
        vector.pushBack(2);
        vector.pushBack(3);
        vector.pushBack(4);
        vector.pushBack(5);
        vector.pushBack(6);
        vector.pushBack(7);
        vector.pushBack(8);
    }

    @Test 
    public void testCase1() {
        Assertions.assertEquals(8, vector.getSize());
        Assertions.assertEquals(10, vector.getMaxSize());

        vector.insert(4, 15);
        vector.pushBack(9);
        Assertions.assertEquals(10, vector.getSize());
        Assertions.assertEquals(10, vector.getMaxSize());

        vector.pushBack(52);
        Assertions.assertEquals(11, vector.getSize());
        Assertions.assertEquals(30, vector.getMaxSize());
    }

    @Test 
    public void testCase2() {
        vector.changeSize(25);
        Assertions.assertEquals(25, vector.getSize());
        Assertions.assertEquals(60, vector.getMaxSize());
    }

    @Test 
    public void testCase3() {
        vector.insert(4, 15);
        vector.pushBack(9);
        vector.changeSize(25);
        vector.insert(20, 52);
        Assertions.assertEquals(null, vector.popBack());
        Assertions.assertEquals(25, vector.getSize());
        Assertions.assertEquals(60, vector.getMaxSize());
    }

    @Test 
    public void testCase4() {
        myVector<Integer> copiedVector = new myVector<>(vector);

        vector.clear();
        Assertions.assertEquals(0, vector.getSize());
        Assertions.assertEquals(0, vector.getMaxSize());

        Assertions.assertEquals(8, copiedVector.getSize());
        Assertions.assertEquals(10, copiedVector.getMaxSize());
    }

    public static void main(String[] args) {
        System.out.println("SIZE " + vector.getSize());
        System.out.println("MAX SIZE " + vector.getMaxSize());
        System.out.println(vector.toString());
        vector.insert(4, 15);
        vector.pushBack(9);
        System.out.println("SIZE " + vector.getSize());
        System.out.println("MAX SIZE " + vector.getMaxSize());
        System.out.println(vector.toString());

        vector.changeSize(25);
        System.out.println("CHANGE SIZE OF VECTOR FROM 10 TO 25");
        System.out.println("SIZE " + vector.getSize());
        System.out.println("MAX SIZE " + vector.getMaxSize());
        System.out.println(vector.toString());

        vector.insert(20, 52);
        vector.popBack();
        System.out.println(vector.toString());

        myVector<Integer> copiedVector = new myVector<>(vector);
        System.out.println(copiedVector.toString());

        vector.clear();
        System.out.println("SIZE " + vector.getSize());
        System.out.println("MAX SIZE " + vector.getMaxSize());
        System.out.println(vector.toString());
    }   
}
