package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * document对象
 * @author 柳继纪
 * @date 10/5/2022
 * @apiNote
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo3.class.getClassLoader().getResource("com/xml/DTD/student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取student元素的集合  getElementsByTag
        Elements student = document.getElementsByTag("student");
        System.out.println(student.get(0));
        System.out.println(student.get(1));

        System.out.println("------------------------分---割---线------------------------");

        //getElementById(String id)
        Element elementById = document.getElementById("111");
        System.out.println(elementById);

        System.out.println("------------------------分---割---线------------------------");


        //getElementsByAttributeValue(String key,String value)
        Elements number = document.getElementsByAttributeValue("number", "001");
        System.out.println(number.size());


        System.out.println("------------------------分---割---线------------------------");


        //getElementsByAttribute(String key)
        Elements name = document.getElementsByAttribute("sex");
        System.out.println(name);
    }
}
