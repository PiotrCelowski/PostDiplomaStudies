public class Osoba {
    private String imie;
    private String nazwisko;
    private final int rokUrodzenia;
    private Adres adres;

    public Osoba(String imie, String nazwisko, int rokUrodzenia, String nazwaUlicy, int nrDomu, String miejscowosc, int kodPocztowy) {
        this(imie, nazwisko, rokUrodzenia, new Adres(nazwaUlicy, nrDomu, miejscowosc, kodPocztowy));
    }

    public Osoba(String imie, String nazwisko, int rokUrodzenia, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", rokUrodzenia=" + rokUrodzenia +
                ", adres=" + adres.toString() +
                '}';
    }

    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("Piotr", "C", 1989, "Massalskiego", 98, "Kraków", 25633);
        System.out.println("Osoba 1: " + osoba1);

        Adres adres = new Adres("Balicka", 22, "Modlniczka", 39399);
        Osoba osoba2 = new Osoba("Marcin", "M", 1990, adres);
        System.out.println("Osoba 2: " + osoba2);
    }
}
