package Pb4;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Persoana> persoane = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceți datele pentru persoana " + (i + 1));


            System.out.print("Nume: ");
            String nume = scanner.nextLine();


            String cnp;
            while (true) {
                System.out.print("CNP: ");
                cnp = scanner.nextLine();
                if (Persoana.esteValidCnp(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid. Reîncercați.");
                }
            }


            persoane.add(new Persoana(nume, cnp));
        }

        System.out.println("\nInformațiile introduse:");
        for (Persoana persoana : persoane) {
            System.out.println(persoana);
        }

        scanner.close();
    }
}
