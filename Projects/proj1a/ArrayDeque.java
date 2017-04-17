/**
 * Created by Gen on 4/11/17.
 */
public class ArrayDeque<Item> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] items;

    public ArrayDeque() {
        size = 0;
        items = (Item[]) new Object[8];
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
    }
    public static void main(String[] args) {
        ArrayDeque<String> test1 = new ArrayDeque<>();
        test1.addFirst("1111");
        System.out.println(test1.get(0));
        test1.addFirst("2222");
        System.out.println(test1.get(1));
        test1.addFirst("3333");
        test1.addFirst("4444");
        test1.addFirst("5555");
        System.out.println(test1.get(4));
        System.out.println(test1.get(5));
        System.out.println(test1.get(0));
        //test1.removeFirst();
        test1.addFirst("6666");
        test1.addFirst("7777");
        test1.addFirst("8888");
        System.out.println(test1.get(8));
        test1.addFirst("9999");
        test1.addFirst("10");
/*
        ArrayDeque<String> test2 = new ArrayDeque<>();
        test2.addLast("1111");
        test2.addLast("2222");
        test2.addLast("3333");
        test2.removeLast();
        test2.addLast("4444");
        test2.addLast("5555");
        test2.addLast("6666");
        test2.addLast("7777");
        test2.addLast("8888");
        test2.addLast("9999");
        test2.addLast("10");

        ArrayDeque<String> test3 = new ArrayDeque<>();
        test3.addFirst("1111");
        test3.addFirst("2222");
        test3.addFirst("3333");
        test3.addFirst("4444");
        test3.addFirst("5555");
        test3.removeLast();
        test3.addLast("6666");
        test3.addLast("7777");
        test3.addLast("8888");
        test3.addLast("9999");
        test3.addLast("10");*/

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
            doubleSize(items.length * 2);
        }

    }

    /* Adds an item to the front of the Deque. */
    public void addLast(Item item) {
        items[nextLast] = item;
        size++;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        if (nextLast == nextFirst) {
            doubleSize(items.length * 2);
        }


    }

    public void doubleSize(int capacity) {

        int position = nextFirst; //nextFirst always equals to nextLast when doubleSize get called
        int currentSize = items.length;
        Item[] doubledItems = (Item[]) new Object[capacity];
        for (int i = position + 1; i < currentSize; i++) {
            doubledItems[i - position - 1] = items[i];
        }
        for (int i = 0; i < position; i++) {
            doubledItems[i + currentSize - position - 1] = items[i];
        }
        items = doubledItems;
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

