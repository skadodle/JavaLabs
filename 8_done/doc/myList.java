import java.util.*;

public class myList<T> implements Iterable<T> {
    private class Node {
        private Node next;
        private T data;

        Node(T data) { this.data = data; }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
    Default Constructor
    */
    public myList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
    Constructor of copy List from another one
    @param otherList list from copy
    */
    public myList(myList<T> otherList) {
        this();
        Node currentOther = otherList.head;
        while (currentOther != null) {
            this.pushBack(currentOther.data);
            currentOther = currentOther.next;
        }
    }

    /**
    Method that add element after tail
    @param data element for adding
    */
    public void pushBack(T data) {
        Node newNode = new Node(data);
        size++;
        if (tail == null) {
            firstNode(newNode);
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
    Method that add element before head
    @param data element for adding
    */
    public void pushForward(T data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            firstNode(newNode);
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    private void firstNode(Node node) {
        head = node;
        tail = node;
    }

    
    /**
    Method that remove element from head
    @return head.data the first element in list
    @throws IndexOutOfBoundsException of not enough elements for removing
    */
    public T popForward() throws IndexOutOfBoundsException {
        if (head == null)
            throw new IndexOutOfBoundsException("Illegal pop without elements!");
        T value = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return value;
    }
    /**
    Method that remove element from tail
    @return tail.data the last element in list
    @throws IndexOutOfBoundsException of not enough elements for removing
    */
    public T popBack() throws IndexOutOfBoundsException {
        if (tail == null)
            throw new IndexOutOfBoundsException("Illegal pop without elements!");
        if (size == 1) {
            T value = popForward();
            return value;
        }
        Node currentNode = head;
        T value = tail.data;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }
        tail = currentNode;
        currentNode.next = null;
        size--;
        return value;
    }
    /**
    Method that remove element from list
    @throws IndexOutOfBoundsException of not enough elements for removing
    */
    public void delete(T data) throws IndexOutOfBoundsException, Exception {
        if (head == null)
            throw new IndexOutOfBoundsException("Illegal delete without elements!");
        if (data == head.data) {
            popForward();
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null && currentNode.next.data != data) {
            currentNode = currentNode.next;
        }
        if (currentNode.next.data == data) { 
            if (currentNode.next == tail) { popBack(); }
            else {
                currentNode.next = currentNode.next.next; 
                size--;
           }
        } else { throw new Exception("Element doesn't exist in the List!"); }
    }
    /**
    Method that clear list
    */
    public void clear() {
        size = 0;
        tail = null;
        head = null;
    }

    /**
    Method that return size of list
    @return size count of elements in list
    */
    public int getSize() { return this.size; }
    /**
    Method that print list
    */
    public void printList() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while(currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null)
                sb.append(" - ");
            currentNode = currentNode.next;
        }
        if (size == 1)
            sb.append(currentNode.data);
        System.out.println(sb.toString());
    }

    /**
    Method that return String of elements from list
    @return String string of elements
     */
    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while(currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null)
                sb.append(" - ");
            currentNode = currentNode.next;
        }
        if (size == 1)
            sb.append(currentNode.data);
        return sb.toString();
    }

    /**
    Iterator 
     */
    @Override
    public Iterator<T> iterator() {
        return iteratorBegin();
    }

    /**
    Iterator from begin
     */
    public Iterator<T> iteratorBegin() {
        return new Iterator<T>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (currentNode == null) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    /**
    Iterator from last
     */
    public Iterator<T> iteratorEnd() {
        return new Iterator<T>() {
            private Node currentNode = tail;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (currentNode == null) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
