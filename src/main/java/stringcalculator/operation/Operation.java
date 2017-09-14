package stringcalculator.operation;

import java.util.regex.Pattern;

/**
 * Created by Alex on 29/08/2017.
 */
public interface Operation {

    Pattern pattern = Pattern.compile("");

    public int getOrder();

    public String getResult(String inputText);


}
