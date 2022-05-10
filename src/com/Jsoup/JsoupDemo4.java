package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;

/**
 * element对象
 * @author 柳继纪
 * @date 10/5/2022
 * @apiNote
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo4.class.getClassLoader().getResource("com/xml/DTD/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //通过 Document 对象获取 name 标签，获取所有的 name 标签
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());

        //通过element对象获取子标签对象
        Element student = document.getElementsByTag("student").get(0);
        System.out.println(student);
        Elements names = student.getElementsByTag("name");
        System.out.println(names.size());

        //获取属性值
        String number = student.attr("number");
        System.out.println(number);

        String text = names.text();
        String html = names.html();
        System.out.println(text);
        System.out.println(html);
    }
}
