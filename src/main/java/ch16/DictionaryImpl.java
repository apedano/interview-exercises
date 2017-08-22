package ch16;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Alex on 21/08/2017.
 */
public class DictionaryImpl implements Dictionary {

    private Set<String> words;

    public DictionaryImpl(String wordsFileName) throws FileNotFoundException {
        InputStream inputStream = this.getClass().getResourceAsStream(wordsFileName);
        List<String> doc =
                new BufferedReader(new InputStreamReader(inputStream,
                        StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        words = new TreeSet<String>(doc);
    }

    @Override
    public boolean isValid(String word) {
        return words.contains(word);
    }
}
