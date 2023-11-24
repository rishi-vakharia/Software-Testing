package linearalgebra;

// Using JUnit4

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit testing for our Vector class.
 */
public class VectorTest {

    private double delta = 0.00001; // to compare floating-point numbers

    @Test
    public void testGet() {

        Vector v = new Vector(1,2,3);

        assertEquals(2, Vector.get(v, 1), delta);  // using static functions for testing
    }
}
