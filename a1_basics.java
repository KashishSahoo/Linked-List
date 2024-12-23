import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

class LL {
    static Node head;
    int size;

    LL() {
        size = 0;
    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(String string) {
            // TODO Auto-generated constructor stub
        }

    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;

        }
        lastNode.next = newNode;

    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
        head = head.next;
        size--;

    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;

        }
        size--;
        if (head.next == null) {
            head = null;
            return;

        }
        Node currNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        currNode.next = null;

    }

    public int getSize() {
        return size;
    }

    public void addInMiddle(int index, int data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index value");
            return;

        }

        Node newNode = new Node(data);
        if (head == null || index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currNode = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                Node nextNode = currNode.next;
                currNode.next = newNode; // newNode.next=currNode.next
                newNode.next = nextNode; // curr.next=newNode
                break;
            }
            currNode = currNode.next;
        }
    }

    public int length() {
        int c = 0;
        Node currnode = head;
        while (currnode != null) {
            c++;
            currnode = currnode.next;
        }
        return c;
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public static Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node removeNthFromEndd(Node head, int n) {
        Node start = new Node("");
        start.next = head;
        Node fast = start;
        Node slow = start;

        for (int i = 1; i <= n; ++i)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

    public Node getMiddle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node firstHalfEnd = getMiddle(head);
        Node secondHalfStart = reverseListRecursive(firstHalfEnd.next);
        Node firstHalfStart = head;
        while (secondHalfStart != null) {
            if (secondHalfStart.data != firstHalfStart.data) {
                return false;
            }
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;

        }
        return true;

    }

    public boolean hasLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    public void createLoop() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public void reverseLL() {
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }
        head.next = null;
        head = prev;
    }

    public Node reverseRec(Node head) {
        if (head.next == null) {
            return head;
        }
        Node newNode = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public int checkIfPresent(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val)
                return 1;
            temp = temp.next;
        }
        return 0;
    }

    public void delFirst() {
        if (head == null) {
            System.out.println("The Linked List Is Empty");
        }
        head = head.next;
    }

    public void delLast() {
        if (head == null) {
            System.out.println("The Linked List Is Empty");
        }
        if (head.next == null) {
            head = null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    public void delKNode(int k) {
        int cnt = 0;
        Node curr = head;
        Node prev = null;

        if (head == null) {
            System.out.println("Linked List is Empty");
        } else if (k == 1) {
            head = head.next;
        } else {
            while (curr != null) {
                cnt++;
                if (cnt == k) {
                    prev.next = prev.next.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void delValNode(int val) {
        Node curr = head;
        Node prev = null;

        if (head == null) {
            System.out.println("Linked List is Empty");
        } else if (head.data == val) {
            head = head.next;
        } else {
            while (curr != null) {
                if (curr.data == val) {
                    prev.next = prev.next.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void addAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAtLast(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;

    }

    public static void addAtKth(int data, int k) {
        Node newNode = new Node(data);
        if (head == null) {
            if (k == 1) {
                head = newNode;
            } else {
                System.out.println("Wrong Input");
            }
        }
        if (k == 1) {
            newNode.next = head;
            head = newNode;
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == (k - 1)) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;

        }

    }

    public static void addBeforeVal(int data, int val) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Wrong Input");
        }
        if (head.data == val) {
            newNode.next = head;
            head = newNode;
        }
        Node temp = head;
        boolean found = false;
        while (temp.next != null) {
            if (temp.next.data == val) {
                newNode.next = temp.next;
                temp.next = newNode;
                found = true;
                break;
            }
            temp = temp.next;

        }
        if (found == false) {
            System.out.println("wrong input");
        }

    }

    public void evenOdd() {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while (temp != null && temp.next != null) {
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            arr.add(temp.data);
        }
        temp = head.next;
        while (temp != null && temp.next != null) {
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            arr.add(temp.data);
        }
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }

    }

    public void evenOddList() {
        if (head == null || head.next == null) {
            return;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    @SuppressWarnings("unused")
    public void sortLL() {
        Node temp = head;

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // Count occurrences of 0, 1, and 2
        while (temp != null) {
            if (temp.data == 0) {
                cnt0++;
            } else if (temp.data == 1) {
                cnt1++;
            } else {
                cnt2++;
            }
            temp = temp.next;
        }

        // Update the linked list based on counts
        temp = head;
        while (temp != null) {
            if (cnt0 > 0) {
                temp.data = 0;
                cnt0--;
            } else if (cnt1 > 0) {
                temp.data = 1;
                cnt1--;
            } else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }
    }

    public void sortLLOp() {
        if (head == null || head.next == null) {
            return;
        }
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        head = zeroHead.next;
    }

    public void removeNthFromEnd(int n) {
        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        if (cnt == n) {
            head = head.next;
            return;
        }
        int res = cnt - n; // 1 2 3
        temp = head;
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void removeNthFromEndOp(int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
    }

    public void revLL() {
        Stack<Integer> st = new Stack<>();
        Node temp = head;

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = st.peek();
            st.pop();
            temp = temp.next;
        }
    }

    public void revLLOP() {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        head = prev;
    }

    public boolean isPalindrome() {
        Stack<Integer> st = new Stack<>();
        Node temp = head;

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != st.peek()) {
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return true;
    }

    public Node middle() {
        Node temp = head;
        int cnt = 0;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        int mid = (cnt / 2) + 1;

        temp = head;
        while (temp != null) {
            mid--;
            if (mid == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public Node middleOP() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void addOne(){
        revLLOP();
        Node temp=head;
        int carry=1;
        while(temp!=null){
            temp.data=temp.data+carry;
            if(temp.data<10){
                carry=0;
                break;
            }
            else{
                temp.data=0;
                carry=1;
            }
            temp=temp.next;
        }
        if(carry==1){
            Node newNode=new Node(1);
            revLLOP();
            newNode.next=head;
            head=newNode;
            return;
        }
        revLLOP();
    }
    static Node intersectionPresent(Node head1,Node head2) {
        HashSet<Node> st=new HashSet<>();
       while(head1 != null) {
          st.add(head1);
          head1 = head1.next;
       }
       while(head2 != null) {
           if(st.contains(head2)) return head2;
           head2 = head2.next;
       }
       return null;
   
   }
   


}

class a1_basics {

    public static void main(String args[]) {
        LL list = new LL();

        list.addFirst(9);
        list.addLast(9);
        list.addLast(9);
       
        list.printList();
        list.addOne();
        list.printList();

        // list.removeNthFromEndOp(2);

        // LL.Node ans= list.middle();
        // list.revLLOP(head);
        // System.out.println(ans.data);

    }
}