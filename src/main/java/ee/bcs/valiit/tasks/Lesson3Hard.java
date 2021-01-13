package ee.bcs.valiit.tasks;

import org.hibernate.type.TrueFalseType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import static ee.bcs.valiit.tasks.Lesson2.exercise4;

public class Lesson3Hard {

    public static void main(String[] args) {

//        System.out.println(evenFibonacci(6));
//        randomGame();
        System.out.println(morseCode("sos"));
        System.out.println(morseCode("tere"));
    }

    public static int evenFibonacci(int x){
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int counter = 0;

        for (int i = 0; i <= x; i++) {
            if (exercise4(i) % 2 == 0) {
                counter += exercise4(i);
            }
        }
        return counter;
    }

    public static void randomGame(){
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks

        Random random = new Random();
        int i = random.nextInt(100);
//        System.out.println("The generated random number is " + i);
        System.out.println("The program has generated a random number from 0 - 100");
        Scanner scanner = new Scanner(System.in);
        int turnCounter = 0;

        while (true) {
            System.out.print("Try to guess the number: ");
            int userGuess = scanner.nextInt();
            turnCounter++;

            if (userGuess == i) {
                System.out.println("You Won! Great Job.");
                System.out.println("It took " + turnCounter + " turns to guess the number!");
                break;
            }
            else if (userGuess < i){
                System.out.println("The correct number is bigger... try again!");
            }
            else if (userGuess > i){
                System.out.println("The correct number is smaller... try again!");
            }
        }


    }

    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -

        HashMap<Character, String> morseTranslation = new HashMap<Character, String>();

        morseTranslation.put('s', "...");
        morseTranslation.put('o', "---");
        morseTranslation.put('t', "-");
        morseTranslation.put('e', ".");
        morseTranslation.put('r', ".-.");

        String inMorse = "";

        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);
            inMorse = inMorse + morseTranslation.get(currentLetter) + " ";

        }

        return inMorse;

    }
}
