package xml.saxtest;

import org.junit.Test;
import org.xml.sax.SAXException;

import xml.bean.Person;
import xml.sax.SaxParserHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxTest {
    @Test
    public void test() throws ParserConfigurationException, SAXException, IOException {
        //获取sax解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //通过工厂获取SaxParser实例
        SAXParser parser = factory.newSAXParser();
        //实例化自己创建的SaxParserHandler
        SaxParserHandler handler = new SaxParserHandler();
        File file = new File("src/person.xml");
        parser.parse(file, handler);
        List<Person> list = handler.list;
        System.out.println(list.toString());
    }
}
