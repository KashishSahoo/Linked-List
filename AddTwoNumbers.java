// Definition for singly-linked list.
class Node {
    int data;
    Node next;

    // Constructor with value
    Node(int data) {
        this.data = data;
    }
}

public class AddTwoNumbers {

    // Head of the linked list
    Node head;

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add a node at the end of the list
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

    // Add Two Numbers function
    public Node addTwoNumbers(Node h1, Node h2) {
        Node dummy = new Node(0); // Dummy node to track the head of the result list
        Node temp = dummy; // Pointer to build the result list
        int carry = 0;

        // Iterate through both lists until all nodes are processed
        while (h1 != null || h2 != null || carry == 1) {
            int sum = 0;

            // Add value from l1, if present
            if (h1 != null) {
                sum += h1.data;
                h1 = h1.next;
            }

            // Add value from l2, if present
            if (h2 != null) {
                sum += h2.data;
                h2 = h2.next;
            }

            // Add carry from the previous step
            sum += carry;

            // Update carry for the next step
            carry = sum / 10;

            // Create a new node with the digit (sum % 10)
            Node node = new Node(sum % 10);
            temp.next = node; // Link the new node to the result list
            temp = temp.next; // Move the pointer forward
        }

        return dummy.next; // Return the head of the result list
    }

    // Helper method to print a linked list
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the solution
    public static void main(String[] args) {
        AddTwoNumbers list1 = new AddTwoNumbers();
        AddTwoNumbers list2 = new AddTwoNumbers();

        // Build the first list using addLast
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(3);

        // Build the second list using addLast
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(4);

        // Print the input lists
        System.out.println("List 1:");
        list1.printList(list1.head);
        System.out.println("List 2:");
        list2.printList(list2.head);

        // Add the two numbers
        AddTwoNumbers solution = new AddTwoNumbers();
        Node result = solution.addTwoNumbers(list1.head, list2.head);

        // Print the result list
        System.out.println("Result:");
        list1.printList(result);
    }
}
