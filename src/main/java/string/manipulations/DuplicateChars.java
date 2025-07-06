package string.manipulations;

import java.util.HashSet;
import java.util.Set;

public class DuplicateChars {
    public static void main(String[] args) {
        String str = "Siddhant Dhyani".toLowerCase().replace(" ", "");

        Set<Character> uniqueChars = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!uniqueChars.add(ch)) {
                duplicates.add(ch);
            }
        }

        System.out.println("Duplicate characters: " + duplicates);
        System.out.println("Duplicate characters Count: " + duplicates.size());

        String name="Siddhant Dhyani";
        char[] chars = name.toLowerCase().toCharArray();
        int duplicateCount = 0;
        for(int i=0; i<chars.length; i++) {
            for(int j=i+1; j<chars.length; j++) {
                if (chars[i] == chars[j]) {
                    duplicateCount++;
                }
            }
        }
        System.out.println("Duplicate characters: " + duplicateCount);
    }

}
