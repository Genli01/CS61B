import javax.naming.RefAddr;

/**
 * Created by Gen on 4/11/17.
 */
public class ArrayDeque<Item> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] items;
    private final int RFACTOR = 2;

    public ArrayDeque() {
        size = 0;
        items = (Item[]) new Object[8];
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
    }

    /* Adds an item to the front of the Deque. */
    public void addFirst(Item item) {
        items[nextFirst] = item;
        size++;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        if (nextFirst == nextLast) {
            resize(items.length * RFACTOR);
        }

    }

    /* Adds an item to the back of the Deque. */
    public void addLast(Item item) {
        items[nextLast] = item;
        size++;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        if (nextLast == nextFirst) {
            resize(items.length * RFACTOR);
        }


    }

    public void resize(int capacity) {

        //int position = nextFirst; //nextFirst always equals to nextLast when resize get called
        int currentSize = items.length;
        Item[] newItems = (Item[]) new Object[capacity];
        if (nextFirst >= nextLast) {
            System.arraycopy(items, nextFirst + 1, newItems, 0, currentSize - nextFirst - 1);
            System.arraycopy(items, 0, newItems, currentSize - nextFirst - 1, nextLast);
        }
        /*for (int i = position + 1; i < currentSize; i++) {
            newItems[i - position - 1] = items[i];
        }
        for (int i = 0; i < position; i++) {
            newItems[i + currentSize - position - 1] = items[i];
        }*/
        else {
            System.arraycopy(items, nextFirst + 1, newItems, 0, size);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
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

        if (nextLast < nextFirst) {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();

    }


     /* Removes and returns the item at the front of the Deque.
    If no such item exists, returns null.*/


    public Item removeFirst() {
        Item itemRemoved;
        if (nextFirst == items.length - 1) {
            itemRemoved = items[0];
            items[0] = null;
            nextFirst = 0;
        }
        else {
            itemRemoved = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst++;
        }
        size--;
        if ((double)size / items.length < 0.25 && items.length > 8) {
            resize(items.length / RFACTOR);
        }
        return itemRemoved;
    }

     /* Removes and returns the item at the back of the Deque.
    If no such item exists, returns null.*/

    public Item removeLast() {
        Item itemRemoved;
        if (nextLast == 0) {
            itemRemoved = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        }
        else {
            itemRemoved = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast--;
        }
        size--;
        if ((double)size / items.length < 0.25 && items.length > 8) {
            resize(items.length / RFACTOR);
        }
        return itemRemoved;
    }

    /* Gets the item at the given index, where 0 is the front,
        1 is the next item, and so forth. If no such item exists,
        returns null. Must not alter the deque!*/

    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        if (nextFirst + index + 1 >= items.length) {
            return items[index - (items.length - nextFirst - 1)];
        }
        else {return items[index + nextFirst + 1];}
    }
}

