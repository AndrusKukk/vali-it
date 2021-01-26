package ee.bcs.valiit.tasks.codeWars;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;

public class CW_Max_Min_arrays {
    public static void main(String[] args) {

        int[] minMaxArray = {15, 11, 10, 7, 20};
        System.out.println(Arrays.toString(solve(minMaxArray)));

    }

    public static int[] solve(int[] arr) {
        Arrays.sort(arr);
        int[] newArr = new int[arr.length];

        for (int i = 0; i <= arr.length / 2; i++) {
            int otheri = arr.length - i - 1;
            int indexForBiggest = i*2;
            int indexForSmallest = i*2+1;

            if (indexForBiggest == arr.length) {
                break;
            }
            if (indexForBiggest < arr.length && i < arr.length) {
                int nowBiggest = arr[otheri];
                newArr[indexForBiggest] = nowBiggest;
            }

            if (i != otheri && i < arr.length) {
                int nowSmallest = arr[i];
                newArr[indexForSmallest] = nowSmallest;

            }

        }

        return newArr;
    }
}
