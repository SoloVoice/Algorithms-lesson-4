import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<E> {
    private int size;
    private MyNode<E> firstElement;
    
    private int iter;

    public void insertFirstElement(E value) {
        firstElement = new MyNode<>(value, firstElement);
        size++;
    }

    public E getFirstElement() {
        if (firstElement != null) {
            return firstElement.value;
        } else {
            return null;
        }
    }

    public E removeFirstElement() {
        if (isEmpty()) {
            return null;
        }
        MyNode<E> removedElement = firstElement;
        firstElement = firstElement.nextNode;
        removedElement.nextNode = null;
        size--;
        return removedElement.value;
    }

    public E remove(E value) {
        MyNode<E> currentElement = firstElement;
        MyNode<E> previousElement = null;
        while (currentElement.nextNode != null) {
            if (currentElement.value.equals(value)) {
                break;
            }
            previousElement = currentElement;
            currentElement = currentElement.nextNode;
        }
        if (currentElement == null) {
            return null;
        } else if (firstElement.value.equals(value)) {
            return removeFirstElement();
        } else if (currentElement.value.equals(value)) {
            previousElement.nextNode = currentElement.nextNode;
            currentElement.nextNode = null;
            size--;
            return currentElement.value;
        } else {
            return null;
        }
    }

    public boolean findElement(E value) {
        MyNode<E> currentElement = firstElement;
        while (currentElement.nextNode == null) {
            if (currentElement.value.equals(value)) {
                return true;
            }
            currentElement = currentElement.nextNode;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        MyNode<E> current = firstElement;
        StringBuilder sb = new StringBuilder().append("[");
        while (current != null) {
            sb.append(current.value);
            if (current.nextNode!=null) {
                sb.append(", ");
            }
            current = current.nextNode;
        }
        sb.append("]");
        return sb.toString();
    }

    class MyNode<E> {
        private E value;
        private MyNode nextNode;

        public MyNode(E value, MyNode nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }
}
