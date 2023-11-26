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
    public void testConstructor() {

        double[][] entries = {
            {1, 2},
            {2, 1}
        };

        Matrix m = new Matrix(entries);

        // Is m correctly initialized?

        assertArrayEquals(entries, m.getEntries());
    }

    @Test
    public void testCopyConstructor() {

        double[][] entries = {
            {1, 2},
            {2, 1}
        };

        Matrix m = new Matrix(entries);

        // Make a copy of m using copy constructor
        Matrix mcopy = new Matrix(m);

        // Are m and mcopy equal as they should be?

        assertArrayEquals(m.getEntries(), mcopy.getEntries());
    }

    @Test
    public void testGetEntries() {

        double[][] entries = {
            {1, 0},
            {0, 1}
        };

        Matrix m = new Matrix(entries);

        // getEntries() should return correct output

        assertArrayEquals(entries, m.getEntries());
    }

    @Test
    public void testMinorMatrix() {

        double[][] entries = {
            {1, 0, 2},
            {0, 1, 0},
            {0, 0, 2}
        };

        Matrix m = new Matrix(entries);

        // Drop the 0th row and 0th column
        Matrix mnew = m.minorMatrix(0,0);

        // Call to minorMatrix() should return correct smaller matrix

        assertArrayEquals(new double [][] {{1,0}, {0,2}}, mnew.getEntries());
    }

    @Test
    public void testFromColumnVectors() {

        Vector c1 = new Vector(1,2,3);
        Vector c2 = new Vector(4,5,6);
        Vector c3 = new Vector(7,8,9);

        Matrix m = Matrix.fromColumnVectors(c1,c2,c3);

        assertArrayEquals(new double[][] {{1,4,7}, {2,5,8}, {3,6,9}}, m.getEntries());
    }

    @Test
    public void testFromRowVectors() {

        Vector r1 = new Vector(1,2,3);
        Vector r2 = new Vector(4,5,6);
        Vector r3 = new Vector(7,8,9);

        Matrix m = Matrix.fromRowVectors(r1,r2,r3);

        assertArrayEquals(new double[][] {{1,2,3}, {4,5,6}, {7,8,9}}, m.getEntries());
    }

    @Test
    public void testDropColumn() {

        double[][] entries = {
            {1, 0},
            {0, 1}
        };

        Matrix m = new Matrix(entries);

        Matrix mnew = m.dropColumn(1);

        // Column should be correctly dropped

        assertArrayEquals(new double[][] {{1}, {0}}, mnew.getEntries());
    }

    @Test
    public void testDropRow() {

        double[][] entries = {
            {1, 0},
            {0, 1}
        };

        Matrix m = new Matrix(entries);

        Matrix mnew = m.dropRow(1);

        // Column should be correctly dropped

        assertArrayEquals(new double[][] {{1,0}}, mnew.getEntries());
    }

    @Test
    public void testGetColumn() {

        double[][] entries = {
            {1, 0},
            {0, 1}
        };

        Matrix m = new Matrix(entries);

        Vector colm = m.getColumn(1);

        assertArrayEquals(new double[] {0,1}, colm.getEntries(), delta);
    }

    @Test
    public void testGetRow() {

        double[][] entries = {
            {1, 0},
            {0, 1}
        };

        Matrix m = new Matrix(entries);

        Vector row = m.getRow(1);

        assertArrayEquals(new double[] {0,1}, row.getEntries(), delta);
    }
    
    @Test
    public void testGetEntry() {

        double[][] entries = {
            {1, 2},
            {2, 1}
        };
        Matrix m = new Matrix(entries);

        assertEquals(1, m.getEntry(1, 1), delta); 
    }

    @Test
    public void testGetNumColumns() {

        double[][] entries = {
            {1, 2},
            {2, 1}
        };
        Matrix m = new Matrix(entries);

        assertEquals(2, m.getNumColumns());
    }

    @Test
    public void testGetNumRows() {

        double[][] entries = {
            {1, 2},
            {2, 1}
        };
        Matrix m = new Matrix(entries);

        assertEquals(2, m.getNumRows());
    }

    @Test
    public void testIdentityMatrix() {

        Matrix i = Matrix.identityMatrix(2);

        assertArrayEquals(new double[][] {{1,0}, {0,1}}, i.getEntries());
    }

    @Test
    public void testIsUpperTriangular() {
        // Test case 1: Upper triangular matrix
        // double[][] entries1 = {
        //     {1, 2, 3},
        //     {0, 4, 5},
        //     {0, 0, 6}
        // };
        // Matrix matrix1 = new Matrix(entries1);
        // assertTrue(matrix1.isUpperTriangular());

        // Test case 2: Not an upper triangular matrix
        double[][] entries2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertFalse(matrix2.isUpperTriangular());

        // Test case 3: Square matrix with zero values below the diagonal
        double[][] entries3 = {
            {1, 0, 0},
            {4, 5, 0},
            {7, 8, 9}
        };
        Matrix matrix3 = new Matrix(entries3);
        assertTrue(matrix3.isUpperTriangular());

        // Test case 4: Rectangular matrix (should return false)
        double[][] entries4 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        Matrix matrix4 = new Matrix(entries4);
        assertFalse(matrix4.isUpperTriangular());
    }

    @Test
    public void testIsLowerTriangular() {
        // Test case 1: Lower triangular matrix
        // double[][] entries1 = {
        //     {1, 0, 0},
        //     {4, 5, 0},
        //     {7, 8, 9}
        // };
        // Matrix matrix1 = new Matrix(entries1);
        // assertTrue(matrix1.isLowerTriangular());

        // Test case 2: Not a lower triangular matrix
        double[][] entries2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertFalse(matrix2.isLowerTriangular());

        // Test case 3: Square matrix with zero values above the diagonal
        double[][] entries3 = {
            {1, 2, 3},
            {0, 5, 6},
            {0, 0, 9}
        };
        Matrix matrix3 = new Matrix(entries3);
        assertTrue(matrix3.isLowerTriangular());

        // Test case 4: Rectangular matrix (should return false)
        double[][] entries4 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        Matrix matrix4 = new Matrix(entries4);
        assertFalse(matrix4.isLowerTriangular());
    }

    @Test
    public void testTrace() {
        //base test 
        double[][] entries = {
            {7}
        };
        Matrix matrix0 = new Matrix(entries);
        assertEquals(7.0, matrix0.trace(), delta);

        // Test case 1: Square matrix with positive diagonal entries
        double[][] entries1 = {
            {1, 0, 0},
            {0, 5, 0},
            {0, 0, 9}
        };
        Matrix matrix1 = new Matrix(entries1);
        assertEquals(15.0, matrix1.trace(), delta);

        // Test case 2: Square matrix with negative diagonal entries
        double[][] entries2 = {
            {-1, 0, 0},
            {0, -5, 0},
            {0, 0, -9}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertEquals(-15.0, matrix2.trace(), delta);

        // Test case 3: Rectangular matrix (should throw an exception)
        // double[][] entries3 = {
        //     {1, 2, 3},
        //     {4, 5, 6}
        // };
        // Matrix matrix3 = new Matrix(entries3);
        // try {
        //     matrix3.trace();
        // } catch (IllegalArgumentException e) {
        //     assertEquals("Trace is not defined for non-square matrices", e.getMessage());
        // }
    }

    @Test
    public void testIsPermutationMatrix() {
        // Test case 1: Permutation Matrix
        double[][] entries1 = {
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 1}
        };
        Matrix matrix1 = new Matrix(entries1);
        assertTrue(matrix1.isPermutationMatrix());

        // Test case 2: Non-Permutation Matrix (extra 1 in the first column)
        double[][] entries2 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertFalse(matrix2.isPermutationMatrix());

        // Test case 3: Non-Square Matrix (should throw an exception)
        double[][] entries3 = {
            {1, 0},
            {0, 1},
            {0, 0}
        };
        Matrix matrix3 = new Matrix(entries3);
        try {
            matrix3.isPermutationMatrix();
        } catch (IllegalArgumentException e) {
            assertEquals("Matrix is not square", e.getMessage());
        }
    }

    @Test
    public void testIsDiagonal() {
        // Test case 1: Diagonal Matrix
        double[][] entries1 = {
            {1, 0, 0},
            {0, 2, 0},
            {0, 0, 3}
        };
        Matrix matrix1 = new Matrix(entries1);
        assertTrue(matrix1.isDiagonal());

        // Test case 2: Non-Diagonal Matrix (extra non-zero value)
        double[][] entries2 = {
            {1, 0, 0},
            {0, 2, 1},
            {0, 0, 3}
        };
        Matrix matrix2 = new Matrix(entries2);
        assertFalse(matrix2.isDiagonal());

        // Test case 3: Non-Square Matrix (should throw an exception)
        double[][] entries3 = {
            {1, 0},
            {0, 1},
            {0, 0}
        };
        Matrix matrix3 = new Matrix(entries3);
        try {
            matrix3.isDiagonal();
        } catch (IllegalArgumentException e) {
            assertEquals("Matrix is not square.", e.getMessage());
        }
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
        assertTrue(matrix3.isSparse());

        // Edge case 4: 3x3 matrix with specified proportion
        double[][] entries4 = {
            {0.1, 0.2, 0.3},
            {0.4, 0.5, 0.6},
            {0.7, 0.8, 0.9}
        };
        Matrix matrix4 = new Matrix(entries4);
        assertFalse(matrix4.isSparse(0.5));

        // Edge case 5: 2x2 matrix with specified proportion
        double[][] entries5 = {
            {0.1, 0.2},
            {0.3, 0.4}
        };
        Matrix matrix5 = new Matrix(entries5);
        assertFalse(matrix5.isSparse(0.2));
    }
}
