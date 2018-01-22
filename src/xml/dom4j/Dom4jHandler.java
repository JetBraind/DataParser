package xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import xml.bean.Person;

import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.List;

public class Dom4jHandler {
    @Test
    public void test01() throws DocumentException {
        List<Person> list = getList();
        System.out.println(list.toString());
    }

    public static List<Person> getList() throws DocumentException {
        List<Person> list = new ArrayList<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/person.xml");
        //获取根元素
        Element root = document.getRootElement();
        //获取根元素下的所有元素
        List<Element> elements = root.elements();
        for (Element element : elements) {
            //获取Person元素的id属性
            int id = Integer.parseInt(element.attribute("id").getValue());
            //获取Person元素下的name元素的值
            String name = element.element("name").getTextTrim();
            int age = Integer.parseInt(element.element("age").getTextTrim());
            String sex = element.element("sex").getTextTrim();
            Person p = new Person(id, name, sex, age);
            list.add(p);
        }
        return list;
    }
}
