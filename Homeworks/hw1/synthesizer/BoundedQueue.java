package synthesizer;

/**
 * Created by Gen on 4/26/17.
 */
public interface BoundedQueue<T> {

    int capacity();          // return size of the buffer
    int fillCount();         // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    // is the buffer empty (fillCount equals zero)?
    default boolean isFull() {
        return fillCount() == capacity();
    }

    // is the buffer full (fillCount is same as capacity)?
    default boolean isEmpty() {
        return fillCount() == 0;
    }

}
