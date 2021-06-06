public class MainApp {
    public static void main(String[] args) {
//        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
//        myLinkedList.insertFirstElement("A");
//        myLinkedList.insertFirstElement("B");
//        myLinkedList.insertFirstElement("C");
//        myLinkedList.insertFirstElement("D");
//        myLinkedList.insertFirstElement("E");
//        myLinkedList.insertFirstElement("F");
//        myLinkedList.insertFirstElement("G");
//        myLinkedList.display();
//
//        myLinkedList.removeFirstElement();
//        myLinkedList.removeFirstElement();
//        myLinkedList.removeFirstElement();
//        myLinkedList.remove("B");
//        myLinkedList.remove("A");
//        myLinkedList.remove("D");
//        myLinkedList.remove("F");
//        System.out.println(myLinkedList.findElement("C"));
//        myLinkedList.remove("C");
//        myLinkedList.display();
        MyLinkedDeque<Integer> deque = new MyLinkedDeque<>();
        deque.insertFirstElement(1);
        deque.insertLastElement(2);
        deque.insertFirstElement(3);
        deque.insertLastElement(4);
        deque.insertFirstElement(5);
        deque.insertLastElement(6);
        deque.display();
        System.out.println(deque.getFirstElement());
        System.out.println(deque.getLastElement());
        deque.removeLastElement();
        deque.removeLastElement();
        deque.removeLastElement();
        deque.removeLastElement();
        deque.removeLastElement();
        deque.removeLastElement();
        deque.removeLastElement();
        deque.display();
        System.out.println(deque.findElement(3));
    }
}
