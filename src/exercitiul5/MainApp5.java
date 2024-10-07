package exercitiul5;

import java.util.Random;

public class MainApp5 {
    public static void main(String[] args) {
        int n;
        Random random= new Random();
        int maxi=20;
        int mini=0;
        n=random.nextInt(maxi-mini)+mini;
        System.out.println("Numarul random n este: "+n);
        int fib1=0;
        int fib2=1;
        do{
            int s=fib1;
            fib1=fib2;
            fib2=s+fib2;
        }while (fib2<n);
        if(fib2 == n)
        {
            System.out.println("Numarul apartine sirului Fibonacci");
        }
        else {
            System.out.println("Numarul nu apartine sirului Fibonacci");
        }
    }
}
