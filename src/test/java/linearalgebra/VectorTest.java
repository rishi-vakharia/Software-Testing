
package linearalgebra;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit testing for the Vector class.
 */
public class VectorTest {

	private double delta = 0.00001; // to compare floating-point numbers

	// Constructor Tests
	@Test
	public void testVectorConstructor1() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		assertArrayEquals(new double[]{1.0, 2.0, 3.0}, vector.getEntries(), delta);
	}

	@Test
	public void testVectorConstructor2() {
		Vector emptyVector = new Vector();
		assertEquals(0, emptyVector.length());
	}

	@Test
	public void testCopyConstructor1() {
		Vector original = new Vector(1.0, 2.0, 3.0);
		Vector copy = new Vector(original);
		assertArrayEquals(original.getEntries(), copy.getEntries(), delta);
	}

	@Test
	public void testCopyConstructor2() {
		Vector emptyOriginal = new Vector();
		Vector emptyCopy = new Vector(emptyOriginal);
		assertEquals(0, emptyCopy.length());
	}

	// Getters Tests
	@Test
	public void testGetEntries1() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		assertArrayEquals(new double[]{1.0, 2.0, 3.0}, vector.getEntries(), delta);
	}

	@Test
	public void testGetEntries2() {
		Vector emptyVector = new Vector();
		assertArrayEquals(new double[]{}, emptyVector.getEntries(), delta);
	}

	@Test
	public void testGet1() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		assertEquals(2.0, vector.get(1), delta);
	}

	@Test
	public void testGet2() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		assertEquals(1.0, vector.get(0), delta);
	}

	@Test
	public void testGet3() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		assertEquals(3.0, vector.get(2), delta);
	}

	@Test
	public void testIdentityVector() {
		Vector identityVector = Vector.identityVector(3);
		assertArrayEquals(new double[]{0.0, 0.0, 0.0}, identityVector.getEntries(), delta);
	}

	// Setters Tests
	@Test
	public void testSet1() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		Vector updatedVector = vector.set(1, 4.0);
		assertArrayEquals(new double[]{1.0, 4.0, 3.0}, updatedVector.getEntries(), delta);
	}

	@Test
	public void testSet2() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		Vector updatedVector = vector.set(0, 4.0);
		assertArrayEquals(new double[]{4.0, 2.0, 3.0}, updatedVector.getEntries(), delta);
	}

	@Test
	public void testSet3() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		Vector updatedVector = vector.set(2, 4.0);
		assertArrayEquals(new double[]{1.0, 2.0, 4.0}, updatedVector.getEntries(), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetException1() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		Vector updatedVector = vector.set(-1, 4.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetException2() {
		Vector vector = new Vector(1.0, 2.0, 3.0);
		Vector updatedVector = vector.set(3, 4.0);
	}

	@Test
	public void testSetEntries() {
		Vector setEntriesVector = new Vector();
		setEntriesVector.setEntries(new double[]{1.0, 2.0, 3.0});
		assertArrayEquals(new double[]{1.0, 2.0, 3.0}, setEntriesVector.getEntries(), delta);
	}

	// Next Set of Tests
	@Test
	public void testToString() {
		Vector vector = new Vector(1,2,3);
		assertEquals("[1.0, 2.0, 3.0]", vector.toString());
	}

	@Test
	public void testInverseVector1() {
		Vector vector = new Vector(1,2,3);
		assertArrayEquals(new double[] {-1.0,-2.0,-3.0}, vector.inverseVector().getEntries(), delta);
	}

	@Test
	public void testInverseVector2() {
		Vector vector = new Vector(1,2,3);
		assertArrayEquals(new double[] {-1.0,-2.0,-3.0}, Vector.inverseVector(vector).getEntries(), delta);
	}

	@Test
	public void testIsCanonicalBasisVectorNegative() {
		Vector v = new Vector(1,2,3);
		assertEquals(false, v.isCanonicalBasisVector());
	}

	@Test
	public void testIsCanonicalBasisVectorPositive() {
		Vector v = new Vector(0,1,0);
		assertEquals(true, v.isCanonicalBasisVector());
	}

	@Test
	public void testIsZeroNegative() {
		Vector nonZeroVector = new Vector(1.0, 2.0, 3.0);
		assertEquals(false, nonZeroVector.isZero());
	}

	@Test
	public void testIsZeroPositive() {
		Vector zeroVector = new Vector(0.0, 0.0, 0.0);
		assertEquals(true, zeroVector.isZero());
	}

	@Test
	public void testLength() {
		Vector v = new Vector(1.0, 2.0, 3.0);
		assertEquals(3, v.length());
	}

	@Test
	public void testMagnitude1() {
		Vector v = new Vector(3.0, 4.0);
		assertEquals(5.0, v.magnitude(), delta);
	}

	@Test
	public void testMagnitude2() {
		Vector v = new Vector(0.0, 0.0, 0.0);
		assertEquals(0.0, v.magnitude(), delta);
	}

	@Test
	public void testNormalize() {
		Vector v = new Vector(3.0, 4.0);
		Vector vnorm = v.normalize();
		assertArrayEquals(new double[] {0.6, 0.8}, vnorm.getEntries(), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNormalizeException() {
		Vector v = new Vector(0.0, 0.0, 0.0);
		Vector vnorm = v.normalize();
	}

	@Test
	public void testPNorm() {
		Vector v = new Vector(1.0, 2.0, 3.0);
		assertEquals(6.0, v.pnorm(1), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPNormException() {
		Vector v = new Vector(1.0, 2.0, 3.0);
		v.pnorm(0.6);
	}

	@Test
	public void testAdd() {
		Vector v1 = new Vector(1.0, 2.0, 3.0);
		Vector v2 = new Vector(4.0, 5.0, 6.0);
		Vector sum = v1.add(v2);
		assertArrayEquals(new double[]{5.0, 7.0, 9.0}, sum.getEntries(), delta);
	}

	@Test
	public void testAngleDegrees() {
		Vector v1 = new Vector(1.0, 0.0, 0.0);
		Vector v2 = new Vector(0.0, 1.0, 0.0);
		assertEquals(90.0, Vector.angleDegrees(v1, v2), delta);
	}

	@Test
	public void testAngleRadians() {
		Vector v1 = new Vector(1.0, 0.0, 0.0);
		Vector v2 = new Vector(0.0, 1.0, 0.0);
		assertEquals(Math.PI / 2, Vector.angleRadians(v1, v2), delta);
	}

	@Test
	public void testCheckLengthsPositive() {
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(4,5,6);
		Vector.checkLengths(v1, v2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCheckLengthsNegative() {
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(4,5);
		Vector.checkLengths(v1, v2);  // should throw an exception
	}

	@Test
	public void testCross() {
		Vector v1 = new Vector(1.0, 0.0, 0.0);
		Vector v2 = new Vector(0.0, 1.0, 0.0);
		Vector crossprod = v1.cross(v2);
		assertArrayEquals(new double[]{0.0, 0.0, 1.0}, crossprod.getEntries(), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCrossException1() {
		// length should be 3 for cross product
		Vector v1 = new Vector(1.0, 0.0, 0.0, 4.0);
		Vector v2 = new Vector(0.0, 1.0, 0.0);
		Vector crossprod = v1.cross(v2);  // this should throw an exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCrossException2() {
		// length should be 3 for cross product
		Vector v1 = new Vector(1.0, 0.0, 0.0);
		Vector v2 = new Vector(0.0, 1.0, 0.0, 3.0);
		Vector crossprod = v1.cross(v2);  // this should throw an exception
	}

	@Test
	public void testDot() {
		Vector v1 = new Vector(1.0, 2.0, 3.0);
		Vector v2 = new Vector(4.0, 5.0, 6.0);
		assertEquals(32.0, v1.dot(v2), delta);
	}

	@Test
	public void testSubtract() {
		Vector v1 = new Vector(1.0, 2.0, 3.0);
		Vector v2 = new Vector(2.0, 3.0, 4.0);
		Vector difference = v1.subtract(v2);
		assertArrayEquals(new double[]{-1.0, -1.0, -1.0}, difference.getEntries(), delta);
	}

	@Test
	public void testLinearCombination() {
		Vector[] vectors = {
			new Vector(1.0, 2.0),
			new Vector(3.0, 4.0)
		};
		double[] weights = {2.0, -1.0};
		Vector linearCombination = Vector.linearCombination(vectors, weights);
		assertArrayEquals(new double[]{-1.0, 0.0}, linearCombination.getEntries(), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLinearCombinationException() {
		// Number of vectors should match number of weights
		Vector[] vectors = {
			new Vector(1.0, 2.0),
			new Vector(3.0, 4.0)
		};
		double[] weights = {1.0, 2.0, 3.0};
		Vector.linearCombination(vectors, weights); // should throw an exception
	}

	@Test
	public void testMultiply() {
		Vector v = new Vector(1.0, 2.0, 3.0);
		assertArrayEquals(new double[]{2.0, 4.0, 6.0}, v.multiply(2.0).getEntries(), delta);
	}

	@Test
	public void testScalarTripleProduct() {
		Vector a = new Vector(1.0, 2.0, 3.0);
		Vector b = new Vector(4.0, 5.0, 6.0);
		Vector c = new Vector(7.0, 8.0, 9.0);
		double scalarTripleProduct = Vector.scalarTripleProduct(a, b, c);
		assertEquals(0.0, scalarTripleProduct, delta);
	}

	@Test
	public void testOuterProduct() {
		Vector v1 = new Vector(1.0, 2.0);
		Vector v2 = new Vector(3.0, 4.0);
		Matrix outerProduct = v1.outerProduct(v2);
		assertArrayEquals(new double[][] {{3.0, 4.0}, {6.0, 8.0}}, outerProduct.getEntries());
	}

	@Test
	public void testOrthogonalProjection() {
		Vector v1 = new Vector(3.0, 4.0);
		Vector v2 = new Vector(1.0, 1.0);
		Vector projection = v1.orthogonalProjection(v2);
		assertArrayEquals(new double[]{3.5, 3.5}, projection.getEntries(), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrthogonalProjectionException() {
		Vector v1 = new Vector(3.0, 4.0);
		Vector v2 = new Vector(0.0, 0.0);
		Vector projection = v1.orthogonalProjection(v2);  // should throw an exception: Cannot project onto zero vector
	}
}