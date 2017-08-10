package ch7;

import java.util.*;

/**
 * Created by Alex on 10/08/2017.
 */
public class AnagramsFinder {

    private Map<String, List<String>> dictionary = new HashMap<String, List<String>>();

    public AnagramsFinder(List<String> words){
        for(String word : words){
            String signature = getSignature(word);
            if(!dictionary.containsKey(signature)){
                dictionary.put(signature, new LinkedList<String>());
            }
            dictionary.get(signature).add(word);
        }
    }

    /*
    * Different anagrams wil give the same signature, due to char alphabetical sorting.
     */
    private String getSignature(String word) {
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        return new String(wordArray);
    }

    public List<String> getAnagrams(String word){
        String signature = getSignature(word);
        if(!dictionary.containsKey(signature)){
            return new LinkedList<String>();
        }
        return dictionary.get(signature);
    }


}
