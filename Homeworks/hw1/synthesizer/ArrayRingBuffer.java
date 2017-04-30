package synthesizer;
import synthesizer.AbstractBoundedQueue;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] arrayRing;
    private int capacity;
    private int fillCount;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        fillCount = 0;
        first = last = capacity / 2;
        arrayRing = (T[]) new Object[capacity];
    }

    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    public void enqueue(T x) {
        if (fillCount == capacity) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        arrayRing[last] = x;
        fillCount++;
        last = increaseOne(last);

    }

    /* Helper method looping Array index */
    private int increaseOne(int index) {
        if (index == capacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int decreaseOne(int index) {
        if (index == 0) {
            return capacity;
        } else {
            return index - 1;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */

    public T dequeue() {
        T removedItem = arrayRing[first];
        arrayRing[first] = null;
        first = increaseOne(first);
        fillCount--;
        return removedItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        T firstItem = arrayRing[first];
        return firstItem;
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
