package exercitiul3;

import java.util.Scanner;

public class MainApp3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("n= ");
        int n=scanner.nextInt();
        int i;
        boolean ok=true;

        System.out.print("Divizorii numarului " + n + " sunt: 1");
        for(i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                ok=false;
                System.out.print("," + i);
            }
        }
        if(n>1)
        {
            System.out.print("," + n);
        }
        if(ok && n>1) {
            System.out.println("\nNumarul este prim");
        }
    }
}
