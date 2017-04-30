package synthesizer;

/**
 * Created by Gen on 4/26/17.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    public abstract int capacity();
    public abstract int fillCount();
    public abstract T peek();
    //public abstract T dequeue();
    //public abstract void enqueue(T x);
    //abstract void moveTo(double deltaX, double deltaY);
}
