class LL {
    Node head;
    int size;
    LL () {
        size = 0;
    }
    public class Node {
        int data;
        Node next;
                public LL.Node prev;
                Node(int data) { 
                    this.data = data; 
                    this.next = null; 
                    size++;
                }
                
            }
            public int checkIfPresent(int val){
                Node temp=head;
                while (temp!=null) {
                 if(temp.data==val) return 1;
                 temp=temp.next;
             }
             return 0;
           }
            public void addFirst(int data) { 
                Node newNode = new Node(data); 
                head.prev=newNode;
        newNode.next = head;
        head = newNode;
    }
    
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return; 
        }
    
        Node lastNode = head; 
        while(lastNode.next != null) {
            lastNode = lastNode.next; 
            
        }
        lastNode.next = newNode; 

    }
    public void printList() {
        Node currNode = head;
        while(currNode != null) { 
            System.out.print(currNode.data+" -> "); 
            currNode = currNode.next;
        }
        System.out.println("null");
    }
    static Node constructLL(int arr[]) {
        // code here
         if (arr.length == 0) return null; // handle empty array case

        // creating the head of the linked list
        Node head = new Node(arr[0]);
        Node cur = head;

        // adding elements to the linked list
        for (int i = 1; i < arr.length; i++) {
            Node tmp = new Node(arr[i]);
            cur.next = tmp;
            cur = tmp;
        }

        // returning the head of the linked list
        return head;
    }
   
}
public class a3_arrToLL {
    public static void main(String[] args) {
    LL list = new LL(); 
    int arr[]={11,33,23,1,13,12,123};
    list.addFirst(arr[0]);
    for(int i=1;i<arr.length;i++){
        list.addLast(arr[i]);
    }
    list.printList();
    int ans=list.checkIfPresent(13);
    System.out.println(ans);
    }
    
}

