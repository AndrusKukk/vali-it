package ee.bcs.valiit.tasks.codeWars;

public class CW_Enough_is_enough {

    public static void main(String[] args) {
        int[] elements = { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 };
        int maxOccurrences = 3;
        deleteNth(elements, maxOccurrences);

    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }

        return null;
    }

}
