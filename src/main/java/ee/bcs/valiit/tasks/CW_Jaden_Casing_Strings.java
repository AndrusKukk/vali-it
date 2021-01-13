package ee.bcs.valiit.tasks;

public class CW_Jaden_Casing_Strings {
    public void main(String[] args) {
        String myString = "How can mirrors be real if our eyes aren't real";

        System.out.println(toJadenCase(myString));
    }

    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if (phrase.equals("") || phrase.equals(null)) {
            return null;
        }
        else {
            for (int i = 0; i < phrase.length(); i++) {
                 char currentChar = phrase.charAt(i);

            }
            return null;
        }
    }

}
