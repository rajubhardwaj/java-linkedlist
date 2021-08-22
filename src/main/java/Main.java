public class Main {
  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();
    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(30);
    linkedList.addLast(40);
    linkedList.addLast(50);
    linkedList.addLast(60);
    System.out.println(linkedList.size());
    linkedList.display();
    linkedList.removeFirst();
    linkedList.display();
    System.out.println(linkedList.getFirst());
    System.out.println(linkedList.getLast());
    System.out.println(linkedList.getAtIndex(3));
    linkedList.display();
    linkedList.addFirst(5);
    linkedList.display();
    linkedList.addAtIndex(2, 25);
    linkedList.display();
    linkedList.removeLast();
    linkedList.display();
    linkedList.reverseLinkedListDataIterative();
    linkedList.display();
      linkedList.reverseLinkedListPointerIterative();
      linkedList.display();
  }

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    public void addFirst(int val) {
      Node temp = new Node(val);
      if (size == 0) {
        head = tail = temp;
      } else {
        temp.next = head;
        head = temp;
      }
      size++;
    }

    public void addLast(int val) {
      Node temp = new Node(val);
      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }
      size++;
    }

    public void addAtIndex(int idx, int val) {
      if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else {
        Node temp = head;
        Node node = new Node(val);
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
      }
    }

    public void removeFirst() {

      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--;
      }
    }

    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return head.data;
      }
    }

    public int getLast() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return tail.data;
      }
    }

    public int getAtIndex(int idx) {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
        return -1;
      } else {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp.data;
      }
    }

    private Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp;
    }

    public void reverseLinkedListDataIterative() {
      int startIndex = 0;
      int endIndex = size-1;
      while (startIndex < endIndex) {
        Node left = getNodeAt(startIndex);
        Node right = getNodeAt(endIndex);
        int temp = left.data;
        left.data = right.data;
        right.data = temp;
        startIndex++;
        endIndex--;
      }
    }

      public void reverseLinkedListPointerIterative() {
      }

    public int size() {
      return size;
    }

    public void display() {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + "\t");
        temp = temp.next;
      }
      System.out.println();
    }


  }
}
