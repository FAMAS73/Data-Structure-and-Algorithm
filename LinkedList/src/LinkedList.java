/*class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}*/

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Function to create a new node
    private Node createNode(int data) {
        return new Node(data);
    }

    // Function to insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = createNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Function to insert at the end
    public void insertAtEnd(int data) {
        Node newNode = createNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Function to insert at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = createNode(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Function to delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    // Function to delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Function to delete at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            Node temp = head;
            head = temp.next;
            temp.next = null;
            return;
        }

        Node temp = head;
        Node prev = null;
        for (int i = 0; i < position && temp != null; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        prev.next = temp.next;
        temp.next = null;
    }

    // Function to search for a node
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true; // Found the data
            }
            current = current.next;
        }
        return false; // Data not found
    }

    // Function to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Inserting elements
        linkedList.insertAtEnd(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtBeginning(4);

        // Printing the initial list
        System.out.print("Original List: ");
        linkedList.printList();

        // Inserting at a specific position
        linkedList.insertAtPosition(5, 2);

        // Printing the list after insertion
        System.out.print("List after insertion: ");
        linkedList.printList();

        // Searching for a node
        int searchData = 3;
        boolean isFound = linkedList.search(searchData);
        System.out.println("Node with data " + searchData + " found: " + isFound);

        // Deleting at a specific position
        linkedList.deleteAtPosition(1);

        // Printing the list after deletion
        System.out.print("List after deletion: ");
        linkedList.printList();
    }
}
