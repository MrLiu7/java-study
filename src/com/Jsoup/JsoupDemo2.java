package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author 柳继纪
 * @date 10/5/2022
 * @apiNote
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //方式一
        String path = JsoupDemo2.class.getClassLoader().getResource("com/xml/DTD/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);


        System.out.println("------------------------分---割---线------------------------");

        //方式二
        Document document1 = Jsoup.parse("<!--?xml version=\"1.0\" encoding=\"UTF-8\" ?--><!doctype students[>\n" +
                "<!--ELEMENT students (student*) -->\n" +
                "<!--ELEMENT student (name,age,sex)-->\n" +
                "<!--ELEMENT name (#PCDATA)-->\n" +
                "<!--ELEMENT age (#PCDATA)-->\n" +
                "<!--ELEMENT sex (#PCDATA)-->\n" +
                "<!--ATTLIST student number ID #REQUIRED-->\n" +
                "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "   ]&gt; \n" +
                "  <students> \n" +
                "   <student number=\"s001\"> \n" +
                "    <name>\n" +
                "     张三\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     22\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     男\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "   <student number=\"s002\"> \n" +
                "    <name>\n" +
                "     李四\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     24\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     女\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "  </students>\n" +
                " </body>\n" +
                "</html>\n" +
                "\n" +
                "Process finished with exit code 0\n");
        System.out.println(document1);

        System.out.println("------------------------分---割---线------------------------");


        //方法三 解析网络上的HTML
        Document document2 = Jsoup.parse(new URL("https://www.t262.com/t/142440.html"),10000);
        System.out.println(document2);
    }
}
