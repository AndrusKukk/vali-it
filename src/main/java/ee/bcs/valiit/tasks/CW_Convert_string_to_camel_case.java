package ee.bcs.valiit.tasks;

public class CW_Convert_string_to_camel_case {
    public static void main(String[] args) {
        String myString = "You_have_chosen";

        System.out.println(toCamelCase(myString));

    }

    static String toCamelCase(String s){
        String converted = "";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (i == 0) {
                converted += currentChar;
            }
            else if (s.charAt(i-1) == '_') {
                converted += Character.toUpperCase(currentChar);
            }
            else if (s.charAt(i-1) == '-') {
                converted += Character.toUpperCase(currentChar);
            }
            else {
                converted += currentChar;
            }
        }
        return converted.replaceAll("[_-]", "");
    }
}