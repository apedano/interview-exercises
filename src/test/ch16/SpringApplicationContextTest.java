package ch16;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Alex on 21/08/2017.
 */
public class SpringApplicationContextTest {

    @Test
    public void xmlApplicationContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ch16/applicationContext.xml");
        SpellChecker spellChecker = (SpellChecker) applicationContext.getBean("spellChecker");
        assertTrue(spellChecker.analyze("all' alba e al tramonto sorge il sole"));
    }

    @Test
    public void annotatedClassApplicationContext(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJavaconfiguration.class);
        SpellChecker spellChecker = (SpellChecker) applicationContext.getBean("spellChecker");
        assertTrue(spellChecker.analyze("all' alba e al tramonto sorge il sole"));
    }

    @Test
    public void scopeBeanTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ch16/applicationContext.xml");
        //call to default singleton scope
        SpellChecker spellChecker1 = (SpellChecker) applicationContext.getBean("spellChecker");
        SpellChecker spellChecker2 = (SpellChecker) applicationContext.getBean("spellChecker");
        assertSame(spellChecker1, spellChecker2);
        //get prototype beans
        Date date1 = (Date) applicationContext.getBean("date");
        Date date2 = (Date) applicationContext.getBean("date");
        assertNotSame(date1, date2);
    }



}
