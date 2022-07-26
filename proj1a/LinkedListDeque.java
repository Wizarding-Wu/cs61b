/** A double-ended queue using linked list data structure. */
public class LinkedListDeque<T> {
    private class DeNode {
        public DeNode front;
        public DeNode next;
        public T item;

        public DeNode(T i, DeNode f, DeNode n) {
            item = i;
            front = f;
            next = n;
        }
    }

    private DeNode sentinel; // The next of sentinel will be the first item, the front of sentinel will be the last item.
    private int size;
    private T SENTINEL_ITEM;

    // construction
    public LinkedListDeque() {
        size = 0;
        sentinel = new DeNode(SENTINEL_ITEM, null, null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DeNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            DeNode newNode = new DeNode(item, sentinel, sentinel);
            sentinel.next = newNode; // The first node and last node are both the new node.j
            sentinel.front = newNode;
        } else {
            sentinel.next = new DeNode(item, sentinel, sentinel.next);
        }
        size++;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            sentinel.front.next = new DeNode(item, sentinel.front, sentinel);
            sentinel.front = sentinel.front.next;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        if (size == 1) {
            sentinel.next = null;
            sentinel.front = null;
        } else {
            sentinel.next = sentinel.next.next;
            sentinel.next.front = sentinel;
        }
        size--;
        return  item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.front.item;
        if (size == 1) {
            sentinel.next = null;
            sentinel.front = null;
        } else {
            sentinel.front = sentinel.front.front;
            sentinel.front.next = sentinel;
        }
        size--;
        return item;
    }

    public T get(int index) {
        if (index > size || index < 0 || size == 0) {
            return null;
        }
        DeNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    private T getRecursiveHelper(int index, DeNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }
    public T getRecursive(int index) {
        if (index >= size || index < 0 || size == 0) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }
}
