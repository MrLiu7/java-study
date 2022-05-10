package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 快捷选择器
 *
 * @author 柳继纪
 * @date 10/5/2022
 * @apiNote
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo5.class.getClassLoader().getResource("com/xml/schema/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //快捷查询student标签并且number属性值为heima_0001的age子标签
        Elements elements = document.select("student[number='heima_0001'] > age");
        System.out.println(elements);
    }
}
