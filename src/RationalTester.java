public class RationalTester {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2); // 1/2
        Rational r2 = new Rational(3, 4); // 3/4

        System.out.println(r1.plus(r2));          // 5/4
        System.out.println(Rational.plus(r1, r2)); // 5/4

        System.out.println(Rational.NULL); // 0/1
        System.out.println(Rational.EINS); // 1/1
    }

}
