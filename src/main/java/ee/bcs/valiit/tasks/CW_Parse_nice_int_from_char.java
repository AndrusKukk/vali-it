package ee.bcs.valiit.tasks;

public class CW_Parse_nice_int_from_char {
    public static void main(String[] args) {
        String myString2 = "6 years old";

        System.out.println(howOld(myString2));


    }

    public static int howOld(final String herOld) {
        char firstChar = herOld.charAt(0);
        int age = Integer.parseInt(String.valueOf(firstChar));
        return age;


    }

}