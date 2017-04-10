/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    private int[] items;
    private int size;
    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size >= items.length) {
            int[] newItems = new int[items.length *2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {

        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int removed = items[size - 1];
        items[size-1] = 0;
        size--;
        return removed;
    }
} 