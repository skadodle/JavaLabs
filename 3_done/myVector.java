import java.lang.reflect.Array;
import java.util.Arrays;

public class myVector<T> {
    private T[] array;
    private int size = 0;
    private int maxSize = 0;
    private final Class<T> type;

    public myVector(Class<T> type) {
        this.type = type;
        this.array = createArray(10);
        this.maxSize = 10;
    }

    public myVector(Class<T> type, int size) {
        this.type = type;
        this.size = size;
        updateMaxSize();
        this.array = createArray(maxSize);
    }

    public myVector(myVector<T> otherVector) {
        this.type = otherVector.type;
        this.array = createArray(otherVector.maxSize);
        System.arraycopy(otherVector.array, 0, this.array, 0, otherVector.size);
        this.size = otherVector.size;
        this.maxSize = otherVector.maxSize;
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[]) Array.newInstance(type, size);
    }

    private void updateMaxSize() {
        maxSize = size * 2 + 10;
    }

    public void pushBack(T data) {
        if (size == maxSize) {
            updateMaxSize();
            array = Arrays.copyOf(array, maxSize);
        }
        array[size++] = data;
    }

    public void pushForward(T data) {
        if (size == 0)
            pushBack(data);
        if (size == maxSize) {
            updateMaxSize();
            array = Arrays.copyOf(array, maxSize);
        }
        for (int i = size; i > 0; i++) {
            array[i] = array[i - 1];
        }
        size++;
        array[0] = data;
    }

    public T popBack() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Empty vector");
        }
        T element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (size == 0)
            throw new IndexOutOfBoundsException("Empty vector");
        array[--size] = null;
    }

    public void insert(int index, T data) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (index >= size) { pushBack(data); }
        else if (index == 0) { pushForward(data); }
        else if (size == maxSize) {
            updateMaxSize();
        } else {
            array = Arrays.copyOf(array, maxSize);
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = data;
            size++;
        }
    }

    public void changeSize(int size) {
        this.size = size;
        updateMaxSize();
        array = Arrays.copyOf(array, maxSize);
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        maxSize = 0;
    }

    public int getSize() { return size; }
    public int getMaxSize() { return maxSize; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.printf("To string, size = %d, maxSize = %d\n", size, maxSize);
        for (int i = 0; i < size; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }
}
