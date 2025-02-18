import java.util.Scanner;

public class Main {

    public static int hexToDec(String hex) {
        return Integer.parseInt(hex, 16);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex=sc.nextLine();
        System.out.println("the number transformed in decimal is: "+hexToDec(hex));
    }
}