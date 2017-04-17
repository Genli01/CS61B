/**
 * Created by Gen on 4/11/17.
 */
public class LinkedListDeque<T> {

    private Item sentinel;
    private int size;

    private class Item {
        public T item;
        public Item prev;
        public Item next;
        public Item(T i) {
            item = i;
            prev = null;
            next = null;
        }
        public Item(T i, Item p, Item n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }

        public T getItem() {
            return item;
        }
    }

    public LinkedListDeque() {
        sentinel = new Item(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    /* Adds an item to the front of the Deque. */
    public void addFirst(T Item) {
        Item x = new Item(Item, sentinel, sentinel.next);
        sentinel.next.prev = x;
        sentinel.next = x;
        size++;
    }

    /* Adds an item to the front of the Deque. */
    public void addLast(T Item) {
        Item addToLast = new Item(Item);
        addToLast.prev = sentinel.prev;
        addToLast.next = sentinel;
        sentinel.prev.next = addToLast;
        sentinel.prev = addToLast;
        size++;
    }

    /*Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the Deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the Deque from first to last,
       separated by a space. */
    public void printDeque() {
        Item ptr = sentinel.next;
        while (ptr.getItem() != null) {
            printItem(ptr);
            ptr = ptr.next;
        }
        System.out.println();

    }

    public void printItem(Item i) {
        System.out.print(i.getItem() + " ");
    }

    /* Removes and returns the item at the front of the Deque.
    If no such item exists, returns null.*/
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            Item removed = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size--;
            return removed;
        }

    }

    /* Removes and returns the item at the back of the Deque.
    If no such item exists, returns null.*/

    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            Item removed = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size--;
            return removed;
        }
    }
    /* Gets the item at the given index, where 0 is the front,
    1 is the next item, and so forth. If no such item exists,
    returns null. */

    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        else {
            Item ptr = sentinel.next;
            for (int i = 0; i < index; i++) {
                ptr = sentinel.next;
            }
            return ptr;
        }
    }

}
