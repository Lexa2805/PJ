package Pb4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {

        int an, luna, zi;
        int sex = Character.getNumericValue(cnp.charAt(0));


        an = Integer.parseInt(cnp.substring(1, 3));
        luna = Integer.parseInt(cnp.substring(3, 5));
        zi = Integer.parseInt(cnp.substring(5, 7));


        if (sex == 1 || sex == 2) {
            an += 1900;
        } else if (sex == 5 || sex == 6) {
            an += 2000;
        }

        LocalDate dataNasterii = LocalDate.of(an, luna, zi);

        return Period.between(dataNasterii, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Nume: " + nume + ", CNP: " + cnp + ", Varsta: " + getVarsta();
    }


    public static boolean esteValidCnp(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }


        for (int i = 0; i < cnp.length(); i++) {
            if (!Character.isDigit(cnp.charAt(i))) {
                return false;
            }
        }


        int primaCifra = Character.getNumericValue(cnp.charAt(0));
        if (primaCifra != 1 && primaCifra != 2 && primaCifra != 5 && primaCifra != 6) {
            return false;
        }


        int[] controlArray = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * controlArray[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) {
            cifraControl = 1;
        }

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }
}
