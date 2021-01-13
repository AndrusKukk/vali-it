package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        //exercise1();
        //exercise2(5);
        //exercise3(3,3);
        System.out.println(exercise4(6));;
        //exercise5(1, 10);
        //exercise5(100, 200);
        //exercise5(201, 210);
        //exercise5(900, 1000);
        //cycleLen(22);

    }

    // TODO loo 10 elemendile täisarvude massiv
    // TODO loe sisse konsoolist 10 täisarvu
    // TODO trüki arvud välja vastupidises järiekorras
    public static void exercise1() {
        int massiiv[] = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Please insert integer: ");
            massiiv[i] = scanner.nextInt();

        }
        for (int i = 9; i >= 0; i--) {
            System.out.println(massiiv[i]);
        }
    }

    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static void exercise2(int x) {
        int limit = 2 * x;
        for (int i = 2; i <= limit; i += 2) {
            System.out.println(i);
        }
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void exercise3(int x, int y) {
        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }


    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element
    public static int exercise4(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return exercise4(n-1) + exercise4(n-2);
        }
    }

    public static void exercise5(int i, int j) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        // TODO 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
        // kui on paaris / 2 kui on paaritu *3+1
        // TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse

        int inputI = i;
        int currentCycle = 0;
        int longestCycle = 0;

        for (; i <= j; i++) {
            currentCycle = cycleLen(i);
            if (currentCycle > longestCycle) {
                longestCycle = currentCycle;
            }
        }

        System.out.println(inputI + " " + j + " " + longestCycle);
    }

    public static int cycleLen(int input){
        int counter = 0;
        //System.out.print(input + " ");
        while (true) {
            counter++;
            if (input == 1) {
                break;
            }
            else if (input % 2 != 0) {
                input = (input * 3) + 1;
                //System.out.print(input + " ");
            }
            else {
                input = input/2;
                //System.out.print(input + " ");
            }
        }
        //System.out.println("");
        //System.out.println("Cycle length: " + counter);
        return  counter;
    }





}
