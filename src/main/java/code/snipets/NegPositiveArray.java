package code.snipets;

import java.util.Arrays;
/*
* This a java class which iterates an array and produce the desired output
* */
public class NegPositiveArray {


    // intput arr[] = {-1, 2, 3, -3, 1, -2, 5, 6, 7, -10}, and op = {-1, -3, -2, -10, 2, 3, 1, 5, 6…}
    public static void main(String[] args) {

        int[] arr = {-1, 2, 3, -3, 1, -2, 5, 6, 7, -10};
        int[] result = new int[arr.length];
        int index = 0;
// First negatives
        for (int num : arr)
            if (num < 0)
                result[index++] = num;
// Then positives
        for (int num : arr)
            if (num >= 0)
                result[index++] = num;

     System.out.println(Arrays.toString(result));
    }
}
