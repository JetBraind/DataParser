package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {
    public List<Person> list = null;
    Person person = null;
    String value = "";

    //文档开始
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        list = new ArrayList<>();
        System.out.println("解析开始");
    }

    //文档结束
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析结束");
    }

    //遍历开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.trim().equals("Person")) {
            person = new Person();
            int id = Integer.parseInt(attributes.getValue("id"));
            person.setId(id);
        }
    }

    //遍历结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.trim().equals("Person")) {
            list.add(person);
            person = null;
        } else if (qName.trim().equals("name"))
            person.setName(value);
        else if (qName.trim().equals("age"))
            person.setAge(Integer.parseInt(value));
        else if (qName.trim().equals("sex"))
            person.setSex(value);
    }

    //获取元素值
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
    }
}
