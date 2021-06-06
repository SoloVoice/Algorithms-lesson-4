public class MyLinkedDeque<E> {
    private int size;
    private MyNode<E> firstElement;
    private MyNode<E> lastElement;

    public void insertFirstElement(E value) {
        if (isEmpty()) {
            lastElement = new MyNode<>(value, firstElement, lastElement);
            firstElement = lastElement;
        } else {
            MyNode<E> addNode = new MyNode<>(value, firstElement, null);
            firstElement.back = addNode;
            firstElement = addNode;
        }
        size++;
    }

    public void insertLastElement(E value) {
        if (isEmpty()) {
            firstElement = new MyNode<>(value, firstElement, lastElement);
            lastElement = firstElement;
        } else {
            MyNode<E> addNode = new MyNode<>(value, null, lastElement);
            lastElement.forward = addNode;
            lastElement = addNode;
        }
        size++;
    }

    public E getFirstElement() {
        if (firstElement != null) {
            return firstElement.value;
        } else {
            return null;
        }
    }

    public E getLastElement() {
        if (lastElement != null) {
            return lastElement.value;
        } else {
            return null;
        }
    }

    public E removeFirstElement() {
        if (isEmpty()) {
            firstElement = null;
            lastElement = null;
            return null;
        }
        MyNode<E> removedElement = firstElement;
        firstElement = firstElement.forward;
        removedElement.forward = null;
        size--;
        if (isEmpty()) {
            firstElement = null;
            lastElement = null;
        }
        return removedElement.value;
    }

    public E removeLastElement() {
        if (isEmpty()) {
            firstElement = null;
            lastElement = null;
            return null;
        }
        MyNode<E> removedElement = lastElement;
        if (size == 1) {
            removedElement.back = null;
            firstElement = null;
            lastElement = null;
            size--;
            return removedElement.value;
        } else {
            lastElement = lastElement.back;
            lastElement.forward = null;
        }
        size--;
        return removedElement.value;
    }

    public E remove(E value) {
        // Вот тут я немного травму мозга получил. :)
        MyNode<E> currentElement = firstElement;
        MyNode<E> previousElement = null;
        while (currentElement.forward != null) {
            if (currentElement.value.equals(value)) {
                break;
            }
            previousElement = currentElement;
            currentElement = currentElement.forward;
        }
        if (currentElement == null) {
            return null;
        } else if (firstElement.value.equals(value)) {
            return removeFirstElement();
        } else if (currentElement.value.equals(value)) {
            previousElement.forward = currentElement.forward;
            currentElement.forward = null;
            size--;
            return currentElement.value;
        } else {
            return null;
        }
    }

    public boolean findElement(E value) {
        if (isEmpty()) {
            return false;
        }
        MyNode<E> currentElement = firstElement;
        while (currentElement.forward != null) {
            if (currentElement.value.equals(value)) {
                return true;
            }
            currentElement = currentElement.forward;
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
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.value);
            if (current.forward != null) {
                sb.append(", ");
            }
            current = current.forward;
        }
        sb.append("]");
        return sb.toString();
    }

    class MyNode<E> {
        private E value;
        private MyNode forward;
        private MyNode back;

        public MyNode(E value, MyNode forward, MyNode back) {
            this.value = value;
            this.forward = forward;
            this.back = back;
        }
    }
}

