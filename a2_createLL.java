class LL {
    Node head;
    int size;

    LL() {
        size = 0;
    }

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public int lengthOfLL() {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}

public class a2_createLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.printList();
        int ans = list.lengthOfLL();
        System.out.println(ans);
    }
}
