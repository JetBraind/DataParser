package xml.xmltest;

import xml.bean.Person;
import xml.dom4j.Dom4jHandler;

import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<Person> list = Dom4jHandler.getList();
        System.out.println(list.toString());
        System.out.println(System.currentTimeMillis() - start);
    }
}
