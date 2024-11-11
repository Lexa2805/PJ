
package Problema;

public class Imprimanta extends Echipament {
    private int ppm;
    private int dpi;
    private int p_car;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, String nr_inv, double pret, String zona_mag, StareEchipament stare, int ppm, int dpi, int p_car, ModTiparire modTiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }

    public ModTiparire getModTiparire() {
        return modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Imprimanta: " + denumire + " | Număr inventar: " + nr_inv + " | Preț: " + pret +
                " | PPM: " + ppm + " | DPI: " + dpi + " | P/car: " + p_car + " | Mod tipărire: " + modTiparire);
    }
}
