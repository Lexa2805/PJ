package Problema;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Echipament> echipamente = new ArrayList<>();


        try (Scanner scanner = new Scanner(new File("C:/Users/Lexa/IdeaProjects/Lab4/Problema/electronice.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] campuri = line.split(";");


                if (campuri.length < 6) {
                    System.out.println("Linie invalidă: " + line);
                    continue;
                }

                String tip = campuri[5].trim().toLowerCase();
                String denumire = campuri[0].trim();
                String nr_inv = campuri[1].trim();
                double pret = Double.parseDouble(campuri[2].trim());
                String zona_mag = campuri[3].trim();
                StareEchipament stare = StareEchipament.valueOf(campuri[4].trim().toUpperCase());

                try {
                    switch (tip) {
                        case "imprimanta":
                            int ppm = Integer.parseInt(campuri[6].trim());
                            String[] dpiInfo = campuri[7].trim().split("x");
                            int dpi = Integer.parseInt(dpiInfo[0].trim());  // Extrage doar prima valoare
                            int p_car = Integer.parseInt(campuri[8].trim());
                            ModTiparire modTiparire = ModTiparire.valueOf(campuri[9].trim().toUpperCase());
                            echipamente.add(new Imprimanta(denumire, nr_inv, pret, zona_mag, stare, ppm, dpi, p_car, modTiparire));
                            break;
                        case "copiator":
                            int p_ton = Integer.parseInt(campuri[6].trim());
                            FormatCopiere format = FormatCopiere.valueOf(campuri[7].trim().toUpperCase());
                            echipamente.add(new Copiator(denumire, nr_inv, pret, zona_mag, stare, p_ton, format));
                            break;
                        case "sistem de calcul":
                            String tip_mon = campuri[6].trim();
                            double vit_proc = Double.parseDouble(campuri[7].trim());
                            int c_hdd = Integer.parseInt(campuri[8].trim());
                            SistemOperare sistemOperare = SistemOperare.valueOf(campuri[9].trim().toUpperCase());
                            echipamente.add(new SistemeDeCalcul(denumire, nr_inv, pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, sistemOperare));
                            break;
                        default:
                            System.out.println("Tip necunoscut de echipament: " + tip);
                    }
                } catch (Exception e) {
                    System.out.println("Eroare la procesarea liniei: " + line);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit.");
        }

        // Meniu interactiv
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Afișare toate echipamentele");
            System.out.println("2. Afișare imprimante");
            System.out.println("3. Afișare copiatoare");
            System.out.println("4. Afișare sisteme de calcul");
            System.out.println("5. Modifică starea unui echipament");
            System.out.println("6. Setează mod de scriere pentru o imprimantă");
            System.out.println("7. Setează format de copiere pentru un copiator");
            System.out.println("8. Instalează sistem de operare pe un sistem de calcul");
            System.out.println("9. Afișare echipamente vândute");
            System.out.println("10. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            int optiune = input.nextInt();
            input.nextLine();  // Consumăm newline-ul rămas

            switch (optiune) {
                case 1:
                    afisareEchipamente(echipamente, "toate");
                    break;
                case 2:
                    afisareEchipamente(echipamente, "imprimanta");
                    break;
                case 3:
                    afisareEchipamente(echipamente, "copiator");
                    break;
                case 4:
                    afisareEchipamente(echipamente, "sistem de calcul");
                    break;
                case 5:
                    modificaStareEchipament(echipamente, input);
                    break;
                case 6:
                    seteazaModScriereImprimanta(echipamente, input);
                    break;
                case 7:
                    seteazaFormatCopiereCopiator(echipamente, input);
                    break;
                case 8:
                    instaleazaSistemOperare(echipamente, input);
                    break;
                case 9:
                    afisareEchipamenteVandute(echipamente);
                    break;
                case 10:
                    System.out.println("Programul se închide...");
                    input.close();
                    return;
                default:
                    System.out.println("Opțiune invalidă. Vă rugăm să încercați din nou.");
            }
        }
    }


    private static void afisareEchipamente(List<Echipament> echipamente, String tip) {
        boolean hasResults = false;
        for (Echipament echipament : echipamente) {
            if (tip.equals("toate") ||
                    (tip.equals("imprimanta") && echipament instanceof Imprimanta) ||
                    (tip.equals("copiator") && echipament instanceof Copiator) ||
                    (tip.equals("sistem de calcul") && echipament instanceof SistemeDeCalcul)) {
                echipament.afisareDetalii();
                hasResults = true;
            }
        }
        if (!hasResults) {
            System.out.println("Nu există echipamente de tipul " + tip + " de afișat.");
        }
    }
    private static void modificaStareEchipament(List<Echipament> echipamente, Scanner input) {
        System.out.print("Introduceți numărul de inventar al echipamentului: ");
        String nrInv = input.nextLine();
        for (Echipament echipament : echipamente) {
            if (echipament.getNrInv().equals(nrInv)) {
                System.out.print("Introduceți noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
                String stareNoua = input.nextLine().toUpperCase();
                echipament.setStare(StareEchipament.valueOf(stareNoua));
                System.out.println("Starea echipamentului a fost actualizată.");
                return;
            }
        }
        System.out.println("Echipament cu numărul de inventar " + nrInv + " nu a fost găsit.");
    }
    private static void seteazaModScriereImprimanta(List<Echipament> echipamente, Scanner input) {
        System.out.print("Introduceți numărul de inventar al imprimantei: ");
        String nrInv = input.nextLine();
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Imprimanta && echipament.getNrInv().equals(nrInv)) {
                System.out.print("Introduceți noul mod de scriere (COLOR, ALB_NEGRU): ");
                String modNou = input.nextLine().toUpperCase();
                ((Imprimanta) echipament).setModTiparire(ModTiparire.valueOf(modNou));
                System.out.println("Modul de scriere a fost actualizat.");
                return;
            }
        }
        System.out.println("Imprimanta cu numărul de inventar " + nrInv + " nu a fost găsită.");
    }
    private static void seteazaFormatCopiereCopiator(List<Echipament> echipamente, Scanner input) {
        System.out.print("Introduceți numărul de inventar al copiatorului: ");
        String nrInv = input.nextLine();


        for (Echipament echipament : echipamente) {
            if (echipament instanceof Copiator && echipament.getNrInv().equals(nrInv)) {
                System.out.print("Introduceți noul format de copiere (A3, A4): ");
                String formatNou = input.nextLine().toUpperCase();

                try {
                    // Schimbăm formatul de copiere dacă este valid
                    ((Copiator) echipament).setFormat(FormatCopiere.valueOf(formatNou));
                    System.out.println("Formatul de copiere a fost actualizat.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Format invalid. Vă rugăm să introduceți A3 sau A4.");
                }
                return;
            }
        }

        System.out.println("Copiatorul cu numărul de inventar " + nrInv + " nu a fost găsit.");
    }

    private static void instaleazaSistemOperare(List<Echipament> echipamente, Scanner input) {
        System.out.print("Introduceți numărul de inventar al sistemului de calcul: ");
        String nrInv = input.nextLine();
        for (Echipament echipament : echipamente) {
            if (echipament instanceof SistemeDeCalcul && echipament.getNrInv().equals(nrInv)) {
                System.out.print("Introduceți noul sistem de operare (WINDOWS, LINUX): ");
                String sistemNou = input.nextLine().toUpperCase();
                ((SistemeDeCalcul) echipament).setSistemOperare(SistemOperare.valueOf(sistemNou));
                System.out.println("Sistemul de operare a fost instalat.");
                return;
            }
        }
        System.out.println("Sistemul de calcul cu numărul de inventar " + nrInv + " nu a fost găsit.");
    }
    private static void afisareEchipamenteVandute(List<Echipament> echipamente) {
        boolean hasResults = false;
        for (Echipament echipament : echipamente) {
            if (echipament.getStare() == StareEchipament.VANDUT) {
                echipament.afisareDetalii();
                hasResults = true;
            }
        }
        if (!hasResults) {
            System.out.println("Nu există echipamente vândute.");
        }
    }
}
