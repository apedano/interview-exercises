package cmn;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.sun.deploy.util.StringUtils;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Alex on 23/07/2017.
 */
public class Commons {

    public static String printList(List<?> inputList, String separator){
        StringBuilder out = new StringBuilder();
        for(Object o : inputList){
            out.append(o.toString()).append(separator);
        }
        return out.toString();
    }

    public static String joinedList(List<Integer> intList, String separator){
        return StringUtils.join(Lists.transform(intList, new Function<Integer, String>() {
                    @Nullable
                    @Override
                    public String apply(Integer integer) {
                        return String.valueOf(integer);
                    }
                }), separator);
    }
}
