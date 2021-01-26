package ee.bcs.valiit.tasks.codeWars;

public class CW_Jaden_Casing_String {
    public static void main(String[] args) {
        String myString = "How can mirrors be real if our eyes aren't real";

        System.out.println(toJadenCase(myString));
        System.out.println(toJadenCase(null));

    }

    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment


        if (phrase != null && !phrase.isEmpty()) {

            String phraseJC = "";

            for (int i = 0; i < phrase.length(); i++) {
                Character currentChar = phrase.charAt(i);

                if (i == 0) {
                    phraseJC += Character.toUpperCase(currentChar);
                } else if (Character.toUpperCase(phrase.charAt(i - 1)) == ' ') {
                    phraseJC += Character.toUpperCase(currentChar);
                } else {
                    phraseJC += currentChar;
                }

            }
            return phraseJC;
        }
    return null;
    }

}