
package Problema;

public class SistemeDeCalcul extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public SistemeDeCalcul(String denumire, String nr_inv, double pret, String zona_mag, StareEchipament stare, String tip_mon, double vit_proc, int c_hdd, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }

    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Sistem de calcul: " + denumire + " | Număr inventar: " + nr_inv + " | Preț: " + pret +
                " | Tip monitor: " + tip_mon + " | Viteză procesor: " + vit_proc + " GHz | Capacitate HDD: " + c_hdd + " GB | Sistem operare: " + sistemOperare);
    }
}
