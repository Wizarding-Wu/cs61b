public class ArrayDeque<T> {
    private static int INITIAL_SIZE = 8;
    private static int FACTOR = 4;
    private static int REDUCTION_FACTOR = 2;
    private static double MINIMUM_USAGE = 0.25;
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

    private void resize(int length) {

        T[] newItems = (T[]) new Object[length];
        int start = plusOne(nextFirst);
        int end = minusOne(nextLast);
        System.arraycopy(items, start, newItems, 0, items.length - start);
        if (end <= start) {
            System.arraycopy(items, 0, newItems, items.length - start, end + 1);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
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
        nextFirst = plusOne(nextFirst);

        if ((items.length > 16) && ((size * 1.0 / items.length) < MINIMUM_USAGE)) {
            resize(size * REDUCTION_FACTOR);
        }
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
        nextLast = minusOne(nextLast);

        double currentUsage = (size * 1.0) / items.length;
        if ((items.length > 16) && (currentUsage < MINIMUM_USAGE)) {
            resize(size * REDUCTION_FACTOR);
        }
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(nextFirst + index + 1) % items.length];
    }
}
