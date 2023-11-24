package linearalgebra;

// Using JUnit4

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit testing for our Matrix class.
 */
public class MatrixTest {

    private double delta = 0.00001; // to compare floating-point numbers
    
    @Test
    public void testGetEntry() {

        double[][] entries = {
            {1, 2},
            {2, 1}
        };
        Matrix m = new Matrix(entries);

        assertEquals(1, Matrix.getEntry(m, 1, 1), delta); 
    }
}
