package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup的快速入门
 * @author 柳继纪
 * @date 10/5/2022
 * @apiNote
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取 document 对象，根据 xml 文档获取
        //获取 xml 的路径（这里使用类加载器获取）
        String path = JsoupDemo1.class.getClassLoader().getResource("com/xml/DTD/student.xml").getPath();
        //解析xml文档，加载文档进内存，获取DOM树
        //抛出异常
        Document document = Jsoup.parse(new File(path),"UTF-8");
        //获取元素对象（element对象）
        Elements name = document.getElementsByTag("name");
        System.out.println("xml文档中的名为 name 的 element 对象共 "+name.size());
        //获取数据
        Element element = name.get(0);
        String text = element.text();
        System.out.println(text);
    }
}
