package string.manipulations;

import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateWords {

    public static void main(String[] args) {
    String s= "Good morning Ireland Good morning Ireland";

    // String to be in lower case
    s=s.toLowerCase();

    String [] words= s.split("\\s+");
    Map <String, Integer> wordCount= new LinkedHashMap<>();
		for(String word: words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
    }

		System.out.println("Print Duplicate");
		for(Map.Entry<String, Integer> entry: wordCount.entrySet()) {
        if(entry.getValue()>1) {
            System.out.println(entry.getKey()+ " count= "+entry.getValue() );
        }
    }

}
}
