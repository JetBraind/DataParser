package xml.xmltest;

import org.junit.Test;
import org.xml.sax.SAXException;
import xml.bean.Person;
import xml.dom.DomHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DomTest {
    @Test
    public void test01() {
        try {
            long start = System.currentTimeMillis();
            List<Person> list = DomHandler.getParserList();
            System.out.println(list.toString());
            System.out.println(System.currentTimeMillis() - start);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
