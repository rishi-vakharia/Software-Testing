package linearalgebra;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;  // Add this import
import static org.junit.Assert.assertFalse;  // Add this import
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testMultiply() {
        // Test case 1: Square matrices multiplication
        double[][] entries1 = {
            {1, 2},
            {3, 4}
        };
        double[][] entries2 = {
            {5, 6},
            {7, 8}
        };
        Matrix matrix1 = new Matrix(entries1);
        Matrix matrix2 = new Matrix(entries2);
        Matrix result = Matrix.multiply(matrix1, matrix2);

        double[][] expected = {
            {19, 22},
            {43, 50}
        };
        assertArrayEquals(expected, result.getEntries());

        // Test case 2: Rectangular matrices multiplication
        double[][] entries3 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        Matrix matrix3 = new Matrix(entries3);
        Matrix result2 = Matrix.multiply(matrix2, matrix3);

        double[][] expected2 = {
            {29, 40, 51},
            {39, 54, 69}
        };
        assertArrayEquals(expected2, result2.getEntries());

        // Test case 3: Incompatible matrices dimensions
        double[][] entries4 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        Matrix matrix4 = new Matrix(entries4);

        try {
            Matrix.multiply(matrix1, matrix4);
        } catch (IllegalArgumentException e) {
            assertEquals("Matrix dimensions are incompatible.", e.getMessage());
        }
    }

    @Test
    public void testDeterminant() {
        // Edge case 1: 1x1 matrix
        double[][] entries1 = {
            {5}
        };
        Matrix matrix1 = new Matrix(entries1);
        assertEquals(5.0, matrix1.determinant(), delta);

        // Edge case 2: 2x2 matrix
        double[][] entries2 = {
            {2, 3},
            {4, 5}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertEquals(-2.0, matrix2.determinant(), delta);

        // Edge case 3: 3x3 matrix
        double[][] entries3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix matrix3 = new Matrix(entries3);
        assertEquals(0.0, matrix3.determinant(), delta);

        // Edge case 4: 4x4 matrix with all zeros
        double[][] entries4 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        Matrix matrix4 = new Matrix(entries4);
        assertEquals(0.0, matrix4.determinant(), delta);
    }



    @Test
    public void testTranspose() {
        // Edge case 1: 1x1 matrix
        double[][] entries1 = {
            {5}
        };
        Matrix matrix1 = new Matrix(entries1);
        Matrix transposed1 = matrix1.transpose();
        double[][] expected1 = {
            {5}
        };
        assertArrayEquals(expected1, transposed1.getEntries());

        // Edge case 2: 2x3 matrix
        double[][] entries2 = {
            {2, 3, 4},
            {5, 6, 7}
        };
        Matrix matrix2 = new Matrix(entries2);
        Matrix transposed2 = matrix2.transpose();
        double[][] expected2 = {
            {2, 5},
            {3, 6},
            {4, 7}
        };
        assertArrayEquals(expected2, transposed2.getEntries());

        // Edge case 3: 3x2 matrix
        double[][] entries3 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        Matrix matrix3 = new Matrix(entries3);
        Matrix transposed3 = matrix3.transpose();
        double[][] expected3 = {
            {1, 3, 5},
            {2, 4, 6}
        };
        assertArrayEquals(expected3, transposed3.getEntries());

        // Edge case 4: 4x4 matrix with all zeros
        double[][] entries4 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        Matrix matrix4 = new Matrix(entries4);
        Matrix transposed4 = matrix4.transpose();
        assertArrayEquals(entries4, transposed4.getEntries()); // Transposing a matrix of all zeros should remain the same
    }


    @Test
    public void testIsSparse() {
        // Edge case 1: 3x3 matrix with all zeros
        double[][] entries1 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        Matrix matrix1 = new Matrix(entries1);
        assertTrue(matrix1.isSparse());

        // Edge case 2: 2x2 matrix with one non-zero entry
        double[][] entries2 = {
            {0, 0},
            {0, 5}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertTrue(matrix2.isSparse());

        // Edge case 3: 4x4 matrix with half non-zero entries
        double[][] entries3 = {
            {1, 0, 0, 0},
            {0, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 4}
        };
        Matrix matrix3 = new Matrix(entries3);
        assertFalse(matrix3.isSparse());

        // Edge case 4: 3x3 matrix with specified proportion
        double[][] entries4 = {
            {0.1, 0.2, 0.3},
            {0.4, 0.5, 0.6},
            {0.7, 0.8, 0.9}
        };
        Matrix matrix4 = new Matrix(entries4);
        assertTrue(matrix4.isSparse(0.5));

        // Edge case 5: 2x2 matrix with specified proportion
        double[][] entries5 = {
            {0.1, 0.2},
            {0.3, 0.4}
        };
        Matrix matrix5 = new Matrix(entries5);
        assertFalse(matrix5.isSparse(0.2));
    }
}
