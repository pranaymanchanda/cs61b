package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package
import java.util.HashSet;
import java.util.Set;
//package <package name>;
//Make sure this class is public
public class GuitarString{
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int capacity = (int) Math.round(SR/ frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < capacity; i += 1){
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // Dequeue everything in the buffer
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        // Replace with random numbers between -0.5 and 0.5
        Set<Double> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < buffer.capacity()) {
            double r = Math.random() - 0.5;
            uniqueNumbers.add(r);
        }
        for (double r : uniqueNumbers) {
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double front_sample = buffer.dequeue();
        double second_sample = buffer.peek();
        double new_sample = 0.5 * (front_sample + second_sample) * DECAY;
        buffer.enqueue(new_sample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        return buffer.peek();
    }
}