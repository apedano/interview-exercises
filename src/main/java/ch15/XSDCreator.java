package ch15;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 21/08/2017.
 * This class create XSD files from annotated JAXB class
 */
public class XSDCreator {

    public static void createSchema(Class clazz, String suggestedFileName) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);;
        jaxbContext.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String s, String s1) throws IOException {
                File file = new File(suggestedFileName);
                StreamResult result = new StreamResult(file);
                result.setSystemId(file.toURI().toURL().toString());
                return result;
            }
        });
    }

}
