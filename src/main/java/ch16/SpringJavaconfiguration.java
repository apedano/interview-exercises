package ch16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;

/**
 * Created by Alex on 21/08/2017.
 */
@Configuration
public class SpringJavaconfiguration {

    @Bean
    public Dictionary dictionary() throws FileNotFoundException {
        return new DictionaryImpl("target/ch16/italian-dictionary.txt");
    }

    @Bean
    public SpellChecker spellChecker() throws FileNotFoundException {
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.setDictionary(dictionary());
        return spellChecker;
    }
}
