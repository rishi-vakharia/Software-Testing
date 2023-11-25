
// package linearalgebra;


// import static org.junit.Assert.assertArrayEquals;

// import static org.junit.Assert.assertEquals;


// import org.junit.Test;


// /**

//  * Unit testing for the Vector class.

//  */

// public class VectorTest {


//    private double delta = 0.00001; // to compare floating-point numbers


//    // Constructor Tests

//    @Test

//    public void testVectorConstructor() {

//        Vector vector = new Vector(1.0, 2.0, 3.0);

//        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, vector.getEntries(), delta);


//        Vector emptyVector = new Vector();

//        assertEquals(0, emptyVector.length());

//    }


//    @Test

//    public void testCopyConstructor() {

//        Vector original = new Vector(1.0, 2.0, 3.0);

//        Vector copy = new Vector(original);

//        assertArrayEquals(original.getEntries(), copy.getEntries(), delta);


//        Vector emptyOriginal = new Vector();

//        Vector emptyCopy = new Vector(emptyOriginal);

//        assertEquals(0, emptyCopy.length());

//    }


//    // Getters Tests

//    @Test

//    public void testGetEntries() {

//        Vector vector = new Vector(1.0, 2.0, 3.0);

//        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, vector.getEntries(), delta);


//        Vector emptyVector = new Vector();

//        assertArrayEquals(new double[]{}, emptyVector.getEntries(), delta);

//    }


//    @Test

//    public void testGet() {

//        Vector vector = new Vector(1.0, 2.0, 3.0);

//        assertEquals(2.0, vector.get(1), delta);


//        // Additional test cases

//        assertEquals(1.0, vector.get(0), delta);

//        assertEquals(3.0, vector.get(2), delta);

//    }


//    // Setters Tests

//    @Test

//    public void testSet() {

//        Vector vector = new Vector(1.0, 2.0, 3.0);

//        Vector updatedVector = vector.set(1, 4.0);

//        assertArrayEquals(new double[]{1.0, 4.0, 3.0}, updatedVector.getEntries(), delta);


//        // Additional test cases

//        Vector updatedVector2 = vector.set(0, 5.0);

//        assertArrayEquals(new double[]{5.0, 2.0, 3.0}, updatedVector2.getEntries(), delta);

//    }


//    @Test

//    public void testSetEntries() {

//        Vector setEntriesVector = new Vector();

//        setEntriesVector.setEntries(new double[]{1.0, 2.0, 3.0});

//        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, setEntriesVector.getEntries(), delta);


//        // Additional test cases

//        setEntriesVector.setEntries(new double[]{4.0, 5.0, 6.0});

//        assertArrayEquals(new double[]{4.0, 5.0, 6.0}, setEntriesVector.getEntries(), delta);

//    }


//    // Identity Tests

//    @Test

//    public void testIdentityVector() {

//        Vector identityVector = Vector.identityVector(3);

//        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, identityVector.getEntries(), delta);


//        // Additional test cases

//        Vector identityVector2 = Vector.identityVector(2);

//        assertArrayEquals(new double[]{0.0, 0.0}, identityVector2.getEntries(), delta);

//    }


//    // Inverse Tests

//    @Test

//    public void testInverseVector() {

//        Vector inverseVector = new Vector(1.0, -2.0, 3.0);

//        Vector inverse = inverseVector.inverseVector();

//        assertArrayEquals(new double[]{-1.0, 2.0, -3.0}, inverse.getEntries(), delta);


//        // Additional test cases

//        Vector inverseVector2 = new Vector(0.0, 0.0, 0.0);

//        Vector inverse2 = inverseVector2.inverseVector();

//        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, inverse2.getEntries(), delta);

//    }


//    // Is Canonical Basis Vector Tests

//    @Test

//    public void testIsCanonicalBasisVector() {

//        Vector canonicalBasisVector = Vector.identityVector(4);

//        assertEquals(false, canonicalBasisVector.isCanonicalBasisVector());


//        // Additional test cases

//        Vector canonicalBasisVector2 = new Vector(1.0, 0.0);

//        assertEquals(true, canonicalBasisVector2.isCanonicalBasisVector());

//    }


//    // Is Zero Tests

//    @Test

//    public void testIsZero() {

//        Vector zeroVector = new Vector(0.0, 0.0, 0.0);

//        assertEquals(true, zeroVector.isZero());


//        // Additional test cases

//        Vector nonZeroVector = new Vector(1.0, 2.0, 3.0);

//        assertEquals(false, nonZeroVector.isZero());

//    }


//    // Length Tests

//    @Test

//    public void testLength() {

//        Vector lengthVector = new Vector(1.0, 2.0, 3.0);

//        assertEquals(3, lengthVector.length());


//        // Additional test cases

//        Vector lengthVector2 = new Vector(0.0, 0.0, 0.0);

//        assertEquals(0, lengthVector2.length());

//    }


//    // Magnitude Tests

//    @Test

//    public void testMagnitude() {

//        Vector magnitudeVector = new Vector(3.0, 4.0);

//        assertEquals(5.0, magnitudeVector.magnitude(), delta);


//        // Additional test cases

//        Vector magnitudeVector2 = new Vector(0.0, 0.0, 0.0);

//        assertEquals(0.0, magnitudeVector2.magnitude(), delta);

//    }


//    // Normalize Tests

//    @Test

//    public void testNormalize() {

//        Vector normalizeVector = new Vector(3.0, 4.0);

//        Vector normalized = normalizeVector.normalize();

//        assertEquals(1.0, normalized.magnitude(), delta);


//        // Additional test cases

//        Vector normalizeVector2 = new Vector(0.0, 0.0, 0.0);

//        Vector normalized2 = normalizeVector2.normalize();

//        assertEquals(0.0, normalized2.magnitude(), delta);

//    }


//    // P Norm Tests

//    @Test

//    public void testPNorm() {

//        Vector pNormVector = new Vector(1.0, 2.0, 3.0);

//        assertEquals(3.0, pNormVector.pnorm(1), delta);


//        // Additional test cases

//        Vector pNormVector2 = new Vector(1.0, 1.0, 1.0);

//        assertEquals(3.0, pNormVector2.pnorm(1), delta);

//    }


//    // Add Tests

//    @Test

//    public void testAdd() {

//        Vector addVector1 =


//  new Vector(1.0, 2.0, 3.0);

//        Vector addVector2 = new Vector(4.0, 5.0, 6.0);

//        Vector sum = addVector1.add(addVector2);

//        assertArrayEquals(new double[]{5.0, 7.0, 9.0}, sum.getEntries(), delta);


//        // Additional test cases

//        Vector addVector3 = new Vector(-1.0, -2.0, -3.0);

//        Vector sum2 = addVector1.add(addVector3);

//        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, sum2.getEntries(), delta);

//    }


//    // Angle Tests

//    @Test

//    public void testAngleDegrees() {

//        Vector angleVector1 = new Vector(1.0, 0.0, 0.0);

//        Vector angleVector2 = new Vector(0.0, 1.0, 0.0);

//        assertEquals(90.0, Vector.angleDegrees(angleVector1, angleVector2), delta);


//        // Additional test cases

//        Vector angleVector3 = new Vector(1.0, 1.0, 0.0);

//        assertEquals(45.0, Vector.angleDegrees(angleVector1, angleVector3), delta);

//    }


//    @Test

//    public void testAngleRadians() {

//        Vector angleVector1 = new Vector(1.0, 0.0, 0.0);

//        Vector angleVector2 = new Vector(0.0, 1.0, 0.0);

//        assertEquals(Math.PI / 2, Vector.angleRadians(angleVector1, angleVector2), delta);


//        // Additional test cases

//        Vector angleVector3 = new Vector(1.0, 1.0, 0.0);

//        assertEquals(Math.PI / 4, Vector.angleRadians(angleVector1, angleVector3), delta);

//    }


//    // Cross Product Tests

//    @Test

//    public void testCross() {

//        Vector crossVector1 = new Vector(1.0, 0.0, 0.0);

//        Vector crossVector2 = new Vector(0.0, 1.0, 0.0);

//        Vector crossProduct = crossVector1.cross(crossVector2);

//        assertArrayEquals(new double[]{0.0, 0.0, 1.0}, crossProduct.getEntries(), delta);


//        // Additional test cases

//        Vector crossVector3 = new Vector(1.0, 1.0, 0.0);

//        Vector crossProduct2 = crossVector1.cross(crossVector3);

//        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, crossProduct2.getEntries(), delta);

//    }


//    // Dot Product Tests

//    @Test

//    public void testDot() {

//        Vector dotVector1 = new Vector(1.0, 2.0, 3.0);

//        Vector dotVector2 = new Vector(4.0, 5.0, 6.0);

//        assertEquals(32.0, dotVector1.dot(dotVector2), delta);


//        // Additional test cases

//        Vector dotVector3 = new Vector(0.0, 0.0, 0.0);

//        assertEquals(0.0, dotVector1.dot(dotVector3), delta);

//    }


//    // Subtract Tests

//    @Test

//    public void testSubtract() {

//        Vector subtractVector1 = new Vector(1.0, 2.0, 3.0);

//        Vector subtractVector2 = new Vector(2.0, 3.0, 4.0);

//        Vector difference = subtractVector1.subtract(subtractVector2);

//        assertArrayEquals(new double[]{-1.0, -1.0, -1.0}, difference.getEntries(), delta);


//        // Additional test cases

//        Vector subtractVector3 = new Vector(2.0, 2.0, 2.0);

//        Vector difference2 = subtractVector1.subtract(subtractVector3);

//        assertArrayEquals(new double[]{-1.0, 0.0, 1.0}, difference2.getEntries(), delta);

//    }


//    // Linear Combination Tests

//    @Test

//    public void testLinearCombination() {

//        Vector[] vectors = {

//            new Vector(1.0, 2.0),

//            new Vector(3.0, 4.0)

//        };

//        double[] weights = {2.0, -1.0};

//        Vector linearCombination = Vector.linearCombination(vectors, weights);

//        assertArrayEquals(new double[]{-1.0, 0.0}, linearCombination.getEntries(), delta);


//        // Additional test cases

//        Vector[] vectors2 = {

//            new Vector(1.0, 2.0),

//            new Vector(3.0, 4.0),

//            new Vector(5.0, 6.0)

//        };

//        double[] weights2 = {1.0, 2.0, -1.0};

//        Vector linearCombination2 = Vector.linearCombination(vectors2, weights2);

//        assertArrayEquals(new double[]{1.0, 2.0}, linearCombination2.getEntries(), delta);

//    }


//    // Multiply Tests

//    @Test

//    public void testMultiply() {

//        Vector multiplyVector = new Vector(1.0, 2.0, 3.0);

//        Vector product = multiplyVector.multiply(2.0);

//        assertArrayEquals(new double[]{2.0, 4.0, 6.0}, product.getEntries(), delta);


//        // Additional test cases

//        Vector multiplyVector2 = new Vector(0.0, 0.0, 0.0);

//        Vector product2 = multiplyVector2.multiply(5.0);

//        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, product2.getEntries(), delta);

//    }


//    // Scalar Triple Product Tests

//    @Test

//    public void testScalarTripleProduct() {

//        Vector a = new Vector(1.0, 2.0, 3.0);

//        Vector b = new Vector(4.0, 5.0, 6.0);

//        Vector c = new Vector(7.0, 8.0, 9.0);

//        double scalarTripleProduct = Vector.scalarTripleProduct(a, b, c);

//        assertEquals(0.0, scalarTripleProduct, delta);


//        // Additional test cases

//        Vector a2 = new Vector(1.0, 0.0, 0.0);

//        Vector b2 = new Vector(0.0, 1.0, 0.0);

//        Vector c2 = new Vector(0.0, 0.0, 1.0);

//        double scalarTripleProduct2 = Vector.scalarTripleProduct(a2, b2, c2);

//        assertEquals(1.0, scalarTripleProduct2, delta);

//    }




// /*

//    // Outer Product Tests

//    @Test

//    public void testOuterProduct() {

//       Vector outerVector1 = new Vector(1.0, 2.0);

//       Vector outerVector2 = new Vector(3.0, 4.0);

//       Matrix outerProduct = outerVector1.outerProduct(outerVector2);

//       assertArrayEquals(new double[]{3.0, 4.0}, outerProduct.getRow(0), delta);

//       assertArrayEquals(new double[]{6.0, 8.0}, outerProduct.getRow(1), delta);


//    // Add more test cases for the outerProduct method

//    }

// */


//    // Orthogonal Projection Tests

//    @Test

//    public void testOrthogonalProjection() {

//        Vector projectionVector1 = new Vector(3.0, 4.0);

//        Vector projectionVector2 = new Vector(1.0, 1.0);

//        Vector projection = projectionVector1.orthogonalProjection(projectionVector2);

//        assertArrayEquals(new double[]{3.5, 3.5}, projection.getEntries(), delta);


//        // Add more test cases for the orthogonalProjection method

//    }

// }



