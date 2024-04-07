// Node class represents an individual node in the linked list
class Node {
    int data;  // Data of the node
    Node next;  // Reference to the next node in the list

    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SimpleLinkedList class provides basic linked list operations
public class SimpleLinkedList {
    private Node head;  // Reference to the first node in the list

    // Constructor to initialize an empty linked list
    public SimpleLinkedList() {
        this.head = null;
    }

    // Function to add a new node to the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);  // Create a new node
        newNode.next = head;            // Set the new node's next to the current head
        head = newNode;                 // Update the head to the new node
    }


    // Function to search for a node with a specific data value
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;  // Found the data
            }
            current = current.next;
        }
        return false;  // Data not found
    }

    // Function to delete the first occurrence of a node with a specific data value
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + data + " not found");
            return;
        }

        prev.next = current.next;
    }

    // Function to print the elements of the linked list
    public void printList() {
        Node current = head;  // Start from the head
        while (current != null) {
            System.out.print(current.data + " ");  // Print the data of the current node
            current = current.next;                 // Move to the next node
        }
        System.out.println();  // Print a newline at the end
    }

    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();

        // Insert elements at the beginning
        linkedList.insertAtBeginning(3);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(1);

        // Print the linked list
        System.out.print("Linked List: ");
        linkedList.printList();

        // Search for a node
        int searchData = 2;
        boolean isFound = linkedList.search(searchData);
        System.out.println("Node with data " + searchData + " found: " + isFound);

        // Insert at a specific position
        //linkedList.insertAtPosition(4, 2);

        // Print the linked list after insertion
        System.out.print("Linked List after insertion: ");
        linkedList.printList();

        // Delete a node
        linkedList.deleteNode(2);

        // Print the linked list after deletion
        System.out.print("Linked List after deletion: ");
        linkedList.printList();
    }

}
