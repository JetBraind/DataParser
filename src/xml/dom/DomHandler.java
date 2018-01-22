package xml.dom;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml.bean.Person;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomHandler {

    public static List<Person> getParserList() throws ParserConfigurationException, IOException, SAXException {
        List<Person> list = new ArrayList<>();
        Person p = null;
        //构建Dom解析工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //获取Dom构建对象
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        //获取文档对象
        Document document = documentBuilder.parse("src/person.xml");
        //获取开始解析的根标签
        NodeList persons = document.getElementsByTagName("Person");
        for (int i = 0; i < persons.getLength(); i++) {
            p = new Person();
            Node person = persons.item(i);
            //获取节点的所有属性的集合
            NamedNodeMap attrs = person.getAttributes();
            for (int j = 0; j < attrs.getLength(); j++) {
                Node attr = attrs.item(j);
                //判断属性是否存为空
                if (attr != null) {
                    p.setId(Integer.parseInt(attr.getNodeValue()));
                }
                //获取根标签的所有子标签的集合
                NodeList childNode = person.getChildNodes();
                for (int k = 0; k < childNode.getLength(); k++) {
                    Node node = childNode.item(k);
                    //判断是否为元素的标签
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        if (node.getNodeName().equals("name"))
                            //获取标签的内容
                            p.setName(node.getTextContent());
                        if (node.getNodeName().equals("age"))
                            p.setAge(Integer.parseInt(node.getTextContent()));
                        if (node.getNodeName().equals("sex"))
                            p.setSex(node.getTextContent());
                    }
                }
                list.add(p);
                p = null;
            }
        }
        return list;
    }
}
