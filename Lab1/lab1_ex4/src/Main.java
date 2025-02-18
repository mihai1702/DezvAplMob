import java.util.Scanner;

public class Main {
    public static int ValleyCounter(String input) {
        int seaLevel=0;
        int counter=0;
        boolean above=false;
        boolean below=false;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='U'){
                seaLevel++;
            }
            else if(input.charAt(i)=='D'){
                seaLevel--;
            }
            if(seaLevel>=0){
                above=true;
            }
            if(above && seaLevel<0){
                below=true;
            }
            if(below && seaLevel>=0){
                counter++;
                below=false;
                above=false;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(ValleyCounter(input));
    }
}