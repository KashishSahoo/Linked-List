import java.util.Stack;

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

    public void revStack() {
        Stack<Integer> s = new Stack<>();
        Node temp = head;
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = s.peek();
            s.pop();
            temp = temp.next;
        }

    }
    public void reverseDLL() {
        if(head==null || head.next==null){
            return ;
        }
        Node last=null;
        Node curr=head;
        while(curr!=null){
            last =curr.prev;
            curr.prev=curr.next;
            curr.next=last;
            curr=curr.prev;
        }
        head= last.prev;
    }

}

public class a6_revDLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(11);
        list.addLast(22);
        list.addLast(33);
        list.addLast(44);
        list.addLast(55);
        list.printList();
        list.reverseDLL();
        list.printList();

    }
}
