
package Problema;

public class Copiator extends Echipament {
    private int p_ton;
    private FormatCopiere format;

    public Copiator(String denumire, String nr_inv, double pret, String zona_mag, StareEchipament stare, int p_ton, FormatCopiere format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public FormatCopiere getFormat() {
        return format;
    }

    public void setFormat(FormatCopiere format) {
        this.format = format;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Copiator: " + denumire + " | Număr inventar: " + nr_inv + " | Preț: " + pret +
                " | Pagină/toner: " + p_ton + " | Format: " + format);
    }
}
