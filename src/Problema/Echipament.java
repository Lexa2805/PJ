package Problema;

public class Echipament {
    protected String denumire;
    protected String nr_inv;
    protected double pret;
    protected String zona_mag;
    protected StareEchipament stare;

    // Constructor
    public Echipament(String denumire, String nr_inv, double pret, String zona_mag, StareEchipament stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public String getNrInv() {
        return nr_inv;
    }


    public StareEchipament getStare() {
        return stare;
    }


    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }


    public void afisareDetalii() {
        System.out.println("Echipament: " + denumire + " | Număr inventar: " + nr_inv + " | Preț: " + pret + " | Zona: " + zona_mag + " | Stare: " + stare);
    }
}
