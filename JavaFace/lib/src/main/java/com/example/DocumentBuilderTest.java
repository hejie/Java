package com.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuilderTest {
    public void getGameArryLists(String path)
            throws TimeoutException {

        DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();// 有值
        try {
            DocumentBuilder dombuilder = domfac.newDocumentBuilder();// 有值
            HttpURLConnection http = (HttpURLConnection) new URL(path).openConnection();
            http.setConnectTimeout(10000);
            http.setReadTimeout(10000);
            http.setDoInput(true);
            http.setDoOutput(true);
            // 得到网络连接状态
            int nRC = http.getResponseCode();
            if (nRC == HttpURLConnection.HTTP_OK) {
                InputStream is = http.getInputStream();
                Document doc = dombuilder.parse(is);
                // 根节点为<list>节点
                Element root = (Element) doc.getDocumentElement();
                if (root == null || root.getNodeType() != Node.ELEMENT_NODE) {
                }
                // 得到根节点下一层所有节点（包括<vouchlist><netlist>两个节点）
                NodeList mainItems = root.getChildNodes();
                if (mainItems != null) {
                    // 循环读取xml文件中每个标签和下层标签
                    for (int i = 0; i < mainItems.getLength(); i++) {
                        // 0为vouchlist节点，1为netlist节点；
                        Node secondItems = mainItems.item(i);

                        // 获得itemlist下game标签的结合
                        NodeList gamelist = secondItems.getChildNodes();
                        if (gamelist != null) {
                            for (int j = 0; j < gamelist.getLength(); j++) {
                                // list下第i个节点下一层的第j个game节点
                                Node gameitem = gamelist.item(j);

                                if (gameitem.getNodeType() == Node.ELEMENT_NODE) {
//                                    gamedata.setId(gameitem.getAttributes()
//                                            .getNamedItem("id").getNodeValue());
//                                    gamedata.setType(gameitem.getAttributes()
//                                            .getNamedItem("type")
//                                            .getNodeValue());
//                                    gamedata.setIsHot(gameitem.getAttributes()
//                                            .getNamedItem("ishot")
//                                            .getNodeValue());
//                                    gamedata.setName(gameitem.getAttributes()
//                                            .getNamedItem("name")
//                                            .getNodeValue());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//                if (is != null) {
//                    is.close();
//                }
//                if (http != null) {
//                    http.disconnect();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }


        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

            FileInputStream in = new FileInputStream(new File("D:\\workspace\\JavaFace\\writer.xml"));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            //该处返回的Document是JAVA库中内带的 org.w3c.dom.Document
            Document doc = db.parse(in);

            NodeList nodeList = doc.getElementsByTagName("teachers");
            if (nodeList != null && nodeList.getLength() > 0) {
                for (int count = 0; count < nodeList.getLength(); count++) {
                    Node n = nodeList.item(count);
                    NodeList sonList = n.getChildNodes();
                    if (sonList != null && sonList.getLength() > 0) {
                        System.out.println("========================");
                        for (int i = 0; i < sonList.getLength(); i++) {
                            System.out.println("########################");
                            Node son = sonList.item(i);
                            if ("#text".equals(son.getNodeName())) {

                            } else {
                                System.out.println("son.getNodeName() is " + son.getNodeName());
                                System.out.println("son.getNodeValue() is " + son.getNodeValue());
                                System.out.println("son.getTextContent() is " + son.getTextContent());
                                NamedNodeMap map = son.getAttributes();
                                if (map != null && map.getLength() > 0) {
                                    for (int j = 0; j < map.getLength(); j++) {
                                        Node attrs = map.item(j);
                                        System.out.println("attrs.getNodeName() is " + attrs.getNodeName());
                                        System.out.println("attrs.getNodeValue() is " + attrs.getNodeValue());
                                    }
                                }
                            }
                        }

                    }
                }
            }


    }
} 