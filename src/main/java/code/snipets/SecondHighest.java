package code.snipets;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SecondHighest {


    public static void main(String[] args) {


        int [] arr= {10,56,5,89,76,91,99,99};
        int len=arr.length;
        Arrays.sort(arr);

        /*
         * Simple way but has issue if the last number is duplicate
         * */
        System.out.println("Second Highest="+arr[len-2]);

        /*
         * Remove duplicate use set
         * */
        Set<Integer> set1 = new TreeSet<>();
        for (int num : arr) {
            set1.add(num);
        }
        /*
         * Since the Set is of Integer add it needs to changed back to array
         * */
        Integer [] newArr= set1.toArray(new Integer[0]);
        if(newArr.length<2) {
            System.out.println("No Second Highest Element");
        }else {
            System.out.println("Second Highest = "+newArr[newArr.length-2]);
        }

        /* 3rd way of checking second Highest .
         * Find second highest without sorting
         * */

        int first = Integer.MIN_VALUE;
        int second= Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("There is no second highest element (alternative way).");
        } else {
            System.out.println("Second highest (alternative way): " + second);
        }

    }



}
