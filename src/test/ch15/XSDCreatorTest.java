package ch15;

import org.h2.store.fs.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 21/08/2017.
 */
public class XSDCreatorTest {

    public static final String XSD_FILEPATH = "nation.xsd";
    public static final String XML_FILEPATH = "italy.xml";
    private Nation nation;

    @Before
    public void setUp() throws JAXBException, IOException {
        //let's create XSD file
        XSDCreator.createSchema(Nation.class, XSD_FILEPATH);
        //nation creation
        Nation nation = new Nation();
        nation.setName("Italy");
        nation.setLanguage("Italian");
        nation.setPopulation(65000000);
        nation.setFoundation(LocalDate.parse("1861-03-19"));
        List<City> cities = new ArrayList<City>(2);
        City city = new City();
        city.setNome("Roma");
        city.setImportance(1);
        city.setExtension(1200000);
        cities.add(city);
        city = new City();
        city.setNome("Palermo");
        city.setImportance(9);
        city.setExtension(600000);
        cities.add(city);
        nation.setCities(cities);
        this.nation = nation;
    }

    @Test
    public void mashalTest() throws JAXBException, IOException, URISyntaxException, SAXException {

        //Marshal
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(XSD_FILEPATH));

        JAXBContext jaxbContext = JAXBContext.newInstance(Nation.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setSchema(schema);
        try {
            //marshaller.marshal(nation, System.out);
            marshaller.marshal(nation, new FileOutputStream(XML_FILEPATH));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        //UnMarshall
        File file = new File(XML_FILEPATH);
        /**
         * the only difference with the marshaling operation is here
         */
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Nation nation1 = (Nation) jaxbUnmarshaller.unmarshal(file);
        assertEquals(nation, nation1);
        FileUtils.delete(XML_FILEPATH);

    }

    @After
    public void cleanUp() {
        FileUtils.delete(XSD_FILEPATH);

    }


}
