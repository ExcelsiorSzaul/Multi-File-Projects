public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        // Tests
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.displayForward();
        list.displayBackward();
        list.removeNode(2);
        list.addNode(2);
        list.addNode(4);
        list.removeNode(4);
        list.removeNode(1);
        list.displayForward();
        list.removeNode(3);
        list.removeNode(2);
        list.displayForward();
        list.displayBackward();
    }

    public void addNode(int data) {
        // Add A Node To The End Of The List
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void displayForward() {
        // Start At The First Node And Print Forward
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        // Start At The Last Node And Print Backward
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.println();
    }

    public void removeNode(int data) {
        // Case For Removing From Empty List
        if (head == null) {
            System.out.println("The List Is Empty");
            return;
        }

        Node current = head;

        // Iterate Through Until Data Is Found Or List Ends
        while (current != null && current.data != data) {
            current = current.next;
        }

        // If Data Is Not Found
        if (current == null) {
            System.out.println("Node With " + data + " Not Found");
            return;
        }
        
        // If Removed Node Is The Head
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.previous = null;
            }

            if (head == null) {
                tail = null;
            }
        }

        // If Removed Node Is The Tail
        else if (current == tail) {
            tail = current.previous;
            tail.next = null;
        }

        // If Removed Node Is Any Other Node
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        System.out.println("Node With " + data + " Removed");
    }
}
