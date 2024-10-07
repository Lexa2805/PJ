package exercitiul4;

import java.util.Random;

public class MainApp4 {
    public static void main(String[] args) {
        int a,b;
        Random random=new Random();
        a=random.nextInt(30);
        b=random.nextInt(30);
        System.out.println("Numerele generate: "+a+" "+b);

        int minim = Math.min(a, b);
        int cmmdc=1;

        for(int i=2;i<=minim;i++) {
            if (a % i == 0 && b % i == 0) {
                cmmdc = i;
            }
        }
        if(cmmdc==1) {
            System.out.println("Nu au divizor comun mai putin 1");
        }
        else {
            System.out.println("Cmmdc este: "+ cmmdc);
        }
    }
}
