/**
 * Created by Gen on 4/19/17.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque1B {
    @Test
    public void test1() {

        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();
        //Integer randomTestTimes = StdRandom.uniform(100);
        for (Integer i = 0; i < 100; i++) {
            OperationSequence ops = new OperationSequence();
            double randomNum = StdRandom.uniform();
            if (randomNum > 0.5) {
                studentDeque.addFirst(i);
                solutionDeque.addFirst(i);
                DequeOperation op1 = new DequeOperation("addFirst", i);
                ops.addOperation(op1);
            } else {
                studentDeque.addLast(i);
                solutionDeque.addLast(i);
                DequeOperation op1 = new DequeOperation("addLast", i);
                ops.addOperation(op1);
            }
            //DequeOperation op1 = new DequeOperation("addFirst", i);
            //assertEquals(studentDeque.removeLast(), solutionDeque.removeLast());

            double randomNum2 = StdRandom.uniform(3);
            if (randomNum2 < 1.0) {
                Integer expected = solutionDeque.removeFirst();
                Integer actual = studentDeque.removeFirst();
                DequeOperation op2 = new DequeOperation("removeFirst");
                ops.addOperation(op2);
                assertEquals(ops.toString(), expected, actual);
            } else if (randomNum2 < 2.0) {
                Integer expected = solutionDeque.removeLast();
                Integer actual = studentDeque.removeLast();
                DequeOperation op2 = new DequeOperation("removeLast");
                ops.addOperation(op2);
                assertEquals(ops.toString(), expected, actual);
            }

        }
    }
}
