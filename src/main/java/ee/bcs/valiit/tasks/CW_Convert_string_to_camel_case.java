package ee.bcs.valiit.tasks;

public class CW_Convert_string_to_camel_case {
    public static void main(String[] args) {
        String myString = "the_Stealth_Warrior";

        System.out.println(toCamelCase(myString));

    }

    static String toCamelCase(String s){
        String converted = "";

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
//            Character nextChar = s.charAt(i+1);


            if (i == 0) {
                converted += currentChar;
            }
//            else if (Character == " ") {
//
//            }
            else if (Character.toString((s.charAt(i-1))) == "_") {
                converted += Character.toUpperCase(currentChar);
            }
            else if (Character.toString((s.charAt(i-1))) == "-") {
                converted += Character.toUpperCase(currentChar);
            }
            else {
                converted += currentChar;
            }

        }

        return converted;
    }

}