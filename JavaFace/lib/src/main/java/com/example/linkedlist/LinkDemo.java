package com.example.linkedlist;

public class LinkDemo {
    public static void main(String[] args) {
        Link l = new Link();
        l.addNode("A");
        l.addNode("B");
        l.addNode("C");
        l.addNode("D");
        System.out.println("原链表：");
        l.print();
        String searchNode = "C";
        System.out.println("查找节点:" + searchNode);
        String result = l.searchNode(searchNode) ? "找到!" : "没找到!";
        System.out.println("查找结果：" + result);
        System.out.println("删除节点：" + searchNode);
        l.deleteNode(searchNode);
//        l.deleteNode("A");
//        l.deleteNode("D");
//        l.deleteNode("C");
        System.out.println("删除节点后的链表：");
        l.print();
    }
}
