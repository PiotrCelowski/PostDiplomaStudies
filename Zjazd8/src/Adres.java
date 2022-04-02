public class Adres {
    private String nazwaUlicy;
    private int nrDomu;
    private String miejscowosc;
    private int kodPocztowy;

    public Adres(String nazwaUlicy, int nrDomu, String miejscowosc, int kodPocztowy) {
        this.nazwaUlicy = nazwaUlicy;
        this.nrDomu = nrDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nazwaUlicy='" + nazwaUlicy + '\'' +
                ", nrDomu=" + nrDomu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", kodPocztowy=" + kodPocztowy +
                '}';
    }
}