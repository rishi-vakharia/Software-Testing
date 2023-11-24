package linearalgebra;

public class Main {

    public static void main(String[] args) {

        // Trying out Vector class

        Vector v2 = Vector.identityVector(3);

        System.out.println(v2);

        Vector v = new Vector(1,2,3);

        System.out.println(v);

        System.out.println(v.inverseVector());

        System.out.println(v.isCanonicalBasisVector());

        System.out.println(v.isZero());

        System.out.println(v.magnitude());

        System.out.println(v.normalize());

        System.out.println(v.pnorm(3.1));
    }
}