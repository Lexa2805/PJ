package Pb2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MainApp2 {
    public static void main(String[] args) {
        String fisierIntrare = "in.txt";//no no
        String fisierIesire = "out.txt";
        String secventaFinala = "dui";  // Alege secvența de litere
        Random random = new Random();

        ArrayList<Vers> versuri = new ArrayList<>();

        try (Scanner scanner=new Scanner(new File("C:/Users/Lexa/IdeaProjects/Tema2/Pb2/in.txt"))) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                Vers vers = new Vers(linie);
                versuri.add(vers);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit.");
            return;
        }


        try (PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Lexa/IdeaProjects/Tema2/out.txt"))) {
            for (Vers vers : versuri) {
                int numarCuvinte = vers.numaraCuvinte();
                int numarVocale = vers.numaraVocale();
                boolean areSecventa = vers.seTerminaCu(secventaFinala);


                if (random.nextDouble() < 0.1) {
                    writer.print(vers.transformaInMajuscule());
                } else {
                    writer.print(vers.getVers());
                }


                writer.print(" | Cuvinte: " + numarCuvinte);
                writer.print(" | Vocale: " + numarVocale);


                if (areSecventa) {
                    writer.print(" *");
                }

                writer.println();
            }
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea fișierului.");
        }
    }
}