package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        arb.enqueue(22);
        arb.enqueue(10);
        arb.enqueue(-3);
        arb.enqueue(4);
        assertEquals(arb.dequeue(), 22);
        assertEquals(arb.dequeue(), 10);
        assertEquals(arb.peek(), -3);

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
