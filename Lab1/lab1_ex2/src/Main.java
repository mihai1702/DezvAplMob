import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sumA=1;
        int sumB=1;
        for(int i=2;i<=a/2;i++)
        {
            if(a%i==0)
                sumA+=i;
        }
        for(int i=2;i<=b/2;i++)
        {
            if(b%i==0)
                sumB+=i;
        }
        if(sumA==b && sumB==a)
            System.out.println("True");
        else System.out.println("False");
        System.out.println("Sum of the first number is: "+sumA);
        System.out.println("Sum of the second number is: "+sumB);

    }
}