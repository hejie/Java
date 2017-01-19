package com.example.linkedlist;

/**
 * Created by root on 16-2-17.
 */
public class LinkListNew {

      Node head = null;//创建一个空链表,头结点
    Node last = head;//尾结点

    public static void main(String[] args) {

        LinkListNew link = new LinkListNew();

        for (int i = 0; i <= 5; i++) {
            link.add(i);
        }
        link.display();

        link.remove2(2);

        System.out.println("删除后");

        link.display();
    }

    /**
     * 递归打印链表元素的方法
     */
    public void printNode(Node head) {
        if (head != null) {
            System.out.print(" "+head.data);
            Node node = head.next;
            printNode(node);//递归调用
        }
    }
    public void display(){
        if(head == null)
            System.out.println("empty");
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data.toString() + " -> ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    public void add(Object data) {
        Node node = new Node(data);//新建结点
        if (head == null) {
            head = node;
        } else {
            last.next = node;
        }
        last = node;

    }

    public void remove(Object o) {

        if (head.data.equals(o)) {
            head = head.next;
        } else {
            head.next(head.next, o);
        }

    }

    public void remove2(Object obj) {
        if(head == null) {

        }
        if(head.data.equals(obj)){
            head = head.next;
        }else{
            Node pre = head;
            Node cur = head.next;
            while(cur != null){
                if(cur.data.equals(obj)){
                    pre.next = cur.next;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    private static class Node {
        Node next;//下一个结点的引用
        Object data;//结点元素

        public Node(Object data) {
            this.data = data;
        }

        public void next(Node node, Object o) {
            if (this.data.equals(o)) {
                node.next = this.next;
            } else {
                if (node.next != null) {
                    this.next.next(this, o);
                }
            }
        }


    }
}
