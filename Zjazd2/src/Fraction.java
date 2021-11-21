public class Fraction {
    private final int nominator;
    private final int denominator;

    public static Fraction JEDEN = new Fraction(1,1);
    public static Fraction ZERO = new Fraction(0,1);

    public Fraction(int nominator, int denominator) {
        if(denominator < 0) {
            this.nominator = -nominator;
            this.denominator = -denominator;
        } else if(denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero!");
        } else {
            this.nominator = nominator;
            this.denominator = denominator;
        }
    }

    public Fraction(int nominator) {
        this(nominator, 1);
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction anotherFraction) {
        int newNominator = this.getNominator() * anotherFraction.getDenominator()
                + anotherFraction.getNominator() * this.getDenominator();
        int newDenominator = this.getDenominator() * anotherFraction.getDenominator();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction sub(Fraction anotherFraction) {
        int newNominator = this.getNominator() * anotherFraction.getDenominator()
                    - anotherFraction.getNominator() * this.getDenominator();
        int newDenominator = this.getDenominator() * anotherFraction.getDenominator();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction multiply(Fraction anotherFraction) {
        int newNominator = this.getNominator() * anotherFraction.getNominator();
        int newDenominator = this.getDenominator() * anotherFraction.getDenominator();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction divide(Fraction anotherFraction) {
        int newNominator = this.getNominator() * anotherFraction.getDenominator();
        int newDenominator = this.getDenominator() * anotherFraction.getNominator();
        return new Fraction(newNominator, newDenominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "nominator=" + nominator +
                ", denominator=" + denominator +
                '}';
    }

    public static void main(String[] args) {
        Fraction a = new Fraction(1, -2);
        Fraction b = new Fraction(4);
        System.out.println(Fraction.ZERO);
        System.out.println(a.add(b).toString());
        System.out.println(a.sub(b).toString());
        System.out.println(a.multiply(b).toString());
        System.out.println(a.divide(b));
    }
}
