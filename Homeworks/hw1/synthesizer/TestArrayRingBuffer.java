package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void Test1() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(6);
        arb.enqueue(1);
        assertEquals((Integer)1, arb.dequeue());
        arb.enqueue(2);
        assertEquals((Integer)2, arb.dequeue());
        arb.enqueue(3);
        assertEquals((Integer)3, arb.peek());
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        assertEquals(4, arb.fillCount());
        assertEquals(6, arb.capacity());
        arb.enqueue(7);
        arb.enqueue(8);
        assertEquals((Integer)3, arb.dequeue());
        assertEquals((Integer)4, arb.dequeue());
        assertEquals((Integer)5, arb.dequeue());
        assertEquals((Integer)6, arb.dequeue());
        assertEquals(2, arb.fillCount());
        assertEquals(6, arb.capacity());
        assertEquals((Integer)7, arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    /*public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }*/
} 
