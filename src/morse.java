import java.util.Scanner;

public class morse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        morseLogic myMorse = new morseLogic();
        System.out.println("Welcome to the morse translator where we translete singular words into and from morse code.");
        System.out.println("Please write the word in in english or in morse that you want translated.");
        System.out.println("Please be aware that morse in this case is written with * for short and - for long");
        String input = scan.nextLine();
        System.out.println(myMorse.translate(input));

    }
}
