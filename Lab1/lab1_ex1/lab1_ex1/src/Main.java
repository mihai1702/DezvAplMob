import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text=sc.nextLine();
        for(int i=0;i<text.length();i++){
            char x = text.charAt(i);
            if(Character.isLowerCase(x))
                System.out.print(x);
        }
        for(int i=0;i<text.length();i++){
            char x = text.charAt(i);
            if(Character.isUpperCase(x))
                System.out.print(x);
        }
    }
}