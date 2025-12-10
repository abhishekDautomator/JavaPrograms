package DataStructure.LinearDS;

public class DoublyLinkedList {
    Node head;
    Node tail;

    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    // Insert at end
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at beginning
    public void insertAtHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Delete by value
    public void delete(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        Node current = head;
        while (current != null && current.value != value) {
            current = current.next;
        }

        if (current == null) return;

        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;

        if (current.prev != null) current.prev.next = current.next;
    }

    // Reverse the list
    public void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) head = temp.prev;
    }

    // Display forward
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Check for cycle using Floyd's algorithm
    public boolean isCyclic() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Find start of cycle
    public Node cycleStartPoint() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Remove duplicates from sorted list
    public void deleteDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
                if (current.next != null) current.next.prev = current;
                else tail = current;
            } else {
                current = current.next;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);

        System.out.print("Forward: ");
        dll.displayForward();

        System.out.print("Backward: ");
        dll.displayBackward();

        System.out.println("Reversing...");
        dll.reverse();
        dll.displayForward();

        System.out.println("Deleting 3...");
        dll.delete(3);
        dll.displayForward();

        // Creating a cycle for testing
        dll.tail.next = dll.head.next;
        dll.head.next.prev = dll.tail;

        System.out.println("Is cyclic? " + dll.isCyclic());
        Node loopStart = dll.cycleStartPoint();
        if (loopStart != null) {
            System.out.println("Cycle starts at: " + loopStart.value);
        }
    }
}
