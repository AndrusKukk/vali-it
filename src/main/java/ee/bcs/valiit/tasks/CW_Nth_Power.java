package ee.bcs.valiit.tasks;

public class CW_Nth_Power {
    public static void main(String[] args) {
//        int[] myArray = {1, 2, 3, 4};
//        int myN = 2;

//        int[] myArray = {1, 2, 3};
//        int myN = 3;
//
//        System.out.println(nthPower(myArray, myN));;
    }

    public static int nthPower(int[] array, int n) {
        if (n < array.length) {
            int nthElement = array[n];
            return (int) Math.pow(array[n], n);
        }

        else {
            return -1;
        }

    }

}
