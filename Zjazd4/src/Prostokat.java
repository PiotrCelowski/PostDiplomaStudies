
class Kwadrat {
    protected double a;
    protected double wierzcholekX, wierzcholekY;

    public double pole() {return a*a;}
    public double obwod() {return a*4;}
}

public class Prostokat extends Kwadrat {
    private double b;

    public double pole() {return a*b;}
    public double obwod() {return 2*a + 2*b;}
}
