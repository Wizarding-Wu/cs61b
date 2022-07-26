public class ArrayDeque<T> {
    private static int INITIAL_SIZE = 8;
    private static int FACTOR = 4;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = plusOne(index);
        }
        System.out.println();
    }

    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private void resize() {

        T[] newItems = (T[]) new Object[size * FACTOR];
        int start = plusOne(nextFirst);
        System.arraycopy(items, start, newItems, 0, size - start);
        if (start != 0) {
            System.arraycopy(items, 0, newItems, size - start, start);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int index = plusOne(nextFirst);
        T item = items[index];
        items[index] = null;
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int index = minusOne(nextLast);
        T item = items[index];
        items[index] = null;
        size--;
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(nextFirst + index + 1) % items.length];
    }
}
