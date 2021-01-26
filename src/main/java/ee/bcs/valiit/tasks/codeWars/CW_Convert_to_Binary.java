package ee.bcs.valiit.tasks.codeWars;

public class CW_Convert_to_Binary {
    public static void main(String[] args) {
        System.out.println(toBinary(1));
        System.out.println(toBinary(5));
        System.out.println(toBinary(11));

    }

    public static int toBinary(int n) {
        int reminder = n;
        String convertedString = "";

        while (true) {
            if (reminder == 1) {
                convertedString += 1;
                break;
            }
            else {
                int mod = reminder % 2;
                convertedString += Integer.toString(mod);
                reminder = reminder / 2;
            }
        }

        String reversed = new StringBuilder(convertedString).reverse().toString();
        int reversedInt = Integer.parseInt(String.valueOf(reversed));

        return reversedInt;
    }

}