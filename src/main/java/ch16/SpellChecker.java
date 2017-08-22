package ch16;


import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Alex on 21/08/2017.
 */
public class SpellChecker {

    private Dictionary dictionary;

    public boolean analyze(String text){
        System.out.println("Analizyng text: [" + text + "] ...");
        List<String> invalidWords = new LinkedList<String>();
        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        while(tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            if(! dictionary.isValid(word)){
                invalidWords.add(word);
            }
        }

        if(invalidWords.isEmpty()){
            System.out.println("Valid String");
            return true;
        }
        StringBuilder outBuilder = new StringBuilder("String invalid. Invalid words: ");
        outBuilder.append(String.join(",", invalidWords));
        System.out.println(outBuilder.toString());
        return false;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}
