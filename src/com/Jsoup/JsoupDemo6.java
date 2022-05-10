package com.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 柳继纪
 * @date 10/5/2022
 * @apiNote
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemo5.class.getClassLoader().getResource("com/xml/schema/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //创建JXDocument
        JXDocument jxDocument = new JXDocument(document);

        //结合xpath语法查询
        //查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("-----------------------------");

        //查询student标签下的name标签
        for (JXNode jxNode : jxDocument.selN("//student/name")) {
            System.out.println(jxNode);
        }


        System.out.println("-----------------------------");


        //查询student标签下带有id标签的的name对象
        for (JXNode jxNode : jxDocument.selN("//student/name[@id]")) {
            System.out.println(jxNode);
        }
    }
}
