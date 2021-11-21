public class Fraction {
    private int nominator = 0;
    private int denominator = 0;

    public static Fraction JEDEN = new Fraction(1,1);
    public static Fraction ZERO = new Fraction(0,1);

    public Fraction(int nominator, int denominator) {
        if(denominator > 0) {
            this.nominator = nominator;
            this.denominator = denominator;
        } else if(denominator < 0) {
            this.nominator = -nominator;
            this.denominator = -denominator;
        } else if(denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero!");
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
        int newNominator;
        int newDenominator;

        if(checkDenominators(this, anotherFraction)) {
            newNominator = this.getNominator() + anotherFraction.getNominator();
            newDenominator = this.getDenominator();
        } else {
            newNominator = this.getNominator() * anotherFraction.getDenominator()
                    + anotherFraction.getNominator() * this.getDenominator();
            newDenominator = this.getDenominator() * anotherFraction.getDenominator();
        }

        return new Fraction(newNominator, newDenominator);
    }

    public Fraction sub(Fraction anotherFraction) {
        int newNominator;
        int newDenominator;

        if(checkDenominators(this, anotherFraction)) {
            newNominator = this.getNominator() - anotherFraction.getNominator();
            newDenominator = this.getDenominator();
        } else {
            newNominator = this.getNominator() * anotherFraction.getDenominator()
                    - anotherFraction.getNominator() * this.getDenominator();
            newDenominator = this.getDenominator() * anotherFraction.getDenominator();
        }

        return new Fraction(newNominator, newDenominator);
    }

    public Fraction multiply(Fraction anotherFraction) {
        return new Fraction(this.getNominator() * anotherFraction.getNominator(), this.getDenominator() * anotherFraction.getDenominator());
    }

    private boolean checkDenominators(Fraction oneFraction, Fraction anotherFraction) {
        if(oneFraction.getDenominator() == anotherFraction.getDenominator()) {
            return true;
        }
        return false;
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
    }
}
