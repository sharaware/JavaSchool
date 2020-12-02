/*
  root
    |
    +-------+      +-----+
    | data  |      | data|
    | next  |--->  | next| --> null
    +-------+      +-----+
 */

class Node {
    public Node(Object data) {
        this.data = data;
    }
    Object data;
    Node next;
}

public class LList {
    private Node root;

    public void add(Object item) {
        Node tmpItem = new Node(item);
        Node lastItem = findLast();

        if (lastItem != null) {
            lastItem.next = tmpItem;
        } else {
            root = tmpItem;
        }
    }

    public Object get(int id) {
        if (id < 0 || id > this.size()){
            throw new IndexOutOfBoundsException("Illegal index");
        }
        if (root == null) {
            return null;
        }
        Node current = root;
        for (int i = 0; i < id; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        int size;

        if (root == null)
            return 0;
        else {
            size = 1;

            Node current = root;
            while (current.next != null) {
                size++;
                current = current.next;
            }
        }

        return size;
    }


    Node findLast() {
        if (root == null)
            return null;
        else {
            Node current = root;

            while (current.next != null) {
                current = current.next;
            }

            return current;
        }
    }
}
