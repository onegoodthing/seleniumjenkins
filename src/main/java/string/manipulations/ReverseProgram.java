package string.manipulations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseProgram {
/**
 * 3 ways to reverse String
 * */
    public static void main(String[] args) {

        String s= "This is a test statement";

        //Reverse of String through String Builder
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb);

        // Reverse through Char Array
        char[] chars = s.toCharArray();
        int l = chars.length;
        for (int i = l-1; i >=0; i--) {
            System.out.print(chars[i]);
        }

        // Reverse using Collections
        String[] letters = s.split("");                // 1) turn String → array of single-char Strings
        Collections.reverse(Arrays.asList(letters)); // 2) reverse the list *in place*
        String reversed = String.join("", letters);  // 3) join back together
        System.out.println(reversed);

        List<String> list = Arrays.asList(reversed.split(""));
        //Collections.reverse()
    }
    }
