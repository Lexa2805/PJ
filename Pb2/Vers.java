package Pb2;

class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int numaraCuvinte() {
        String[] cuvinte = vers.trim().split("\\s+");
        return cuvinte.length;
    }

    public int numaraVocale() {
        int count = 0;
        String vocale = "aeiouAEIOU";
        for (char c : vers.toCharArray()) {
            if (vocale.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public boolean seTerminaCu(String secventa) {
        return vers.endsWith(secventa);
    }

    public String transformaInMajuscule() {
        return vers.toUpperCase();
    }

    public String getVers() {
        return vers;
    }
}
