package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {

        int[] myArray = {1, 5, 3, 4, 2, 6, 9, 21};
        String myString = "letsTestThisString";

//        System.out.println(sum(myArray));
//        System.out.println(factorial(5));
//        System.out.println(Arrays.toString(sort(myArray)));
//        System.out.println(reverseString(myString));

//        System.out.println(isPrime(2));
//        System.out.println(isPrime(3));
//        System.out.println(isPrime(4));
//        System.out.println(isPrime(5));
//        System.out.println(isPrime(6));
//        System.out.println(isPrime(13));
//        System.out.println(isPrime(25));
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int sum = 0;

        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120

        int sum = 1;

        for (int i = x; i > 0; i--) {
            //System.out.println(i);
            sum *= i;
            //System.out.println(sum);
        }
        return sum;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni

        //int[] sorted = new int[a.length];
        int[] sorted = a;

        for (int i = 0; i < sorted.length; i++) {
            //System.out.println("i= " + i);
            //System.out.println(a[i]);

            for (int j = i + 1; j < sorted.length; j++) {
                //System.out.println("j= " + j);
                //System.out.println(a[j]);

                if (sorted[i] > sorted[j]) {
                    //System.out.println("true!");

                    int buffer = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = buffer;
                }
            }
            //System.out.println(i);
        }
        return sorted;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        String reversed = "";
        for (int i = a.length(); i > 0; --i) {
            //System.out.print(a.charAt(i-1));
            reversed += a.charAt(i - 1);
        }
        return reversed;
    }

    public static boolean isPrime(int x) {
//         TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        boolean check = false;
        System.out.println("Input number: " + x);

        if (x > 1) {
            for (int i = 2; i <= x; i++) {
                if (x == 2) {
                    check = true;
                    break;
                }
                else if (x % 2 == 0) {
                    check = false;
                    break;
                }
                else if ((x % i == 0) && (i < x)) {
                    check = false;
                    break;
                }
                else {
                    check = true;
                }
            }
        } else {
            check = false;
        }
        return check;
    }
}
