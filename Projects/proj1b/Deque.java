/**
 * Created by Gen on 4/22/17.
 */
public interface Deque<Item> {

    void addFirst(Item x); //Adds an item to the front of the Deque.
    void addLast(Item x); //Adds an item to the back of the Deque.
    int size(); //Returns the number of items in the Deque.
    boolean isEmpty(); //Returns true if deque is empty, false otherwise.
    void printDeque(); //Prints the items in the Deque from first to last, separated by a space.
    Item removeFirst(); //Removes and returns the item at the front of the Deque. If no such item exists, returns null.
    Item removeLast(); //Removes and returns the item at the back of the Deque. If no such item exists, returns null.
    Item get(int index);
    /*Gets the item at the given index, where 0 is the front,
    1 is the next item, and so forth. If no such item exists, returns null.*/
}
