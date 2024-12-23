class LL {
    static Node head;
    int size;

    LL() {
        size = 0;
    }

    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void delAtFirst() {
        if (head == null) {
            System.out.println("The Linked List is empty");
        }
        if (head.next == null) {
            head = null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public void delAtLast() {
        if (head == null) {
            System.out.println("The Linked List is empty");
        }
        if (head.next == null) {
            head = null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        prev.next = null;
        tail.prev = null;

    }

    
    public void delAtKth(int k) {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return;
        }

        if (k <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node temp = head;
        int cnt = 1;

        // Traverse to the k-th node
        while (temp != null && cnt < k) {
            temp = temp.next;
            cnt++;
        }

        // If k is larger than the size of the list
        if (temp == null) {
            System.out.println("Position exceeds the size of the list");
            return;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        // Handle edge cases
        if (prevNode == null && nextNode == null) { // Single node case
            head = null;
        } else if (prevNode == null) { // Deleting the first node
            delAtFirst();
            return;
        } else if (nextNode == null) { // Deleting the last node
            delAtLast();
            return;
        } else { // General case
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // Unlink the current node
        temp.next = null;
        temp.prev = null;
    }

    public void delNode(Node temp) {
        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        if (nextNode == null) {
            prevNode.next = null;
            temp.prev = null;
        }
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        temp.next = null;
        temp.prev = null;

    }

    public void addAtBeforeHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Empty List");
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtBeforeLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Empty List");
        }
        if (head.next == null) {
            addAtBeforeHead(data);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prevNode = tail.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = tail;
        tail.prev = newNode;
    }

    public void addBeforeKth(int k, int data) {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return;
        }

        if (k <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int cnt = 1;

        // Traverse to the k-th node
        while (temp != null && cnt < k) {
            temp = temp.next;
            cnt++;
        }

        // If k is larger than the size of the list
        if (temp == null) {
            System.out.println("Position exceeds the size of the list");
            return;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        // Handle edge cases
        if (prevNode == null && nextNode == null) { // Single node
            head = null;
        } else if (prevNode == null) { // the first node
            addAtBeforeHead(data);
            return;
        } else if (nextNode == null) { // the last node
            addAtBeforeLast(data);
            return;
        } else { // General case
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = temp;
            temp.prev = newNode;
        }

    }

    public void addBeforeNode(Node temp, int data) {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = temp.prev;

        // General case
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = temp;
        temp.prev = newNode;

    }

    public void addAtAfterHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Empty List");
        }
        Node nextNode = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    public void addAtAfterLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Empty List");
        }
        if (head.next == null) {
            addAtAfterHead(data);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.prev = tail;

    }

    public void addAfterKth(int k, int data) {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return;
        }

        if (k <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int cnt = 1;

        // Traverse to the k-th node
        while (temp != null && cnt < k) {
            temp = temp.next;
            cnt++;
        }

        // If k is larger than the size of the list
        if (temp == null) {
            System.out.println("Position exceeds the size of the list");
            return;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        // Handle edge cases
        if (prevNode == null && nextNode == null) { // Single node
            head = null;
        } else if (prevNode == null) { // the first node
            addAtAfterHead(data);
            return;
        } else if (nextNode == null) { // the last node
            addAtAfterLast(data);
            return;
        } else { // General case
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }

    }

    public void addAfterNode(Node temp, int data) {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return;
        }

        Node newNode = new Node(data);
        Node nextNode = temp.next;

        // General case
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = nextNode;
        nextNode.prev = newNode;

    }

}

public class a5_doublyLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(11);
        list.addLast(22);
        list.addLast(33);
        list.addLast(44);
        list.addLast(55);
        list.printList();

        // list.addAfterKth(3, 108);
        LL.Node toAddAfter = LL.head.next;
        list.addAfterNode(toAddAfter, 108);
        // list.addBeforeKth(4,108);
        list.printList();
    }
}
