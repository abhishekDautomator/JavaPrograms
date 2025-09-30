package DataStructure.LinearDS;

public class LinkedList {
    Node head;

    public void insert(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null)
            current = current.next;
        current.next = newNode;
    }

    public void delete(int value){
        if(head==null)  return;
        if(head.value==value){ head = head.next; return; }
        Node current = head;
        while(current.next!=null){
            if(current.next.value==value){
                current.next= current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void deleteDuplicateIfAny(){
        if(head == null) return;
        Node current = head;
        while(current.next!=null){
            if(current.value==current.next.value){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.value+" -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public boolean isCyclic(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

    public Node cycleStartPoint(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    //10->20->30->40->null
    public void reverse(){
        Node prev = null; //null //10
        Node current = head; //10 //20
        while(current!=null){
            Node next = current.next; //20 //30
            current.next =prev; //10->null //20->10
            prev = current; // 10 //20
            current = next; // 20 //30
        }
        head=prev; //10 //20
        // 10->null
        // 20->30->40->null

        //20 -> 10 -> null
        //30 -> 40 -> null
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0); // Dummy node to simplify the result list
        Node current = dummyHead; // Pointer to construct the new list
        int carry = 0; // Variable to store carry
        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry
            // Add the value from the first list if available
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next; // Move to the next node
            }
            // Add the value from the second list if available
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next; // Move to the next node
            }
            carry = sum / 10; // Calculate the new carry
            current.next = new Node(sum % 10); // Create a new node with the digit value
            current = current.next; // Move to the next node in the result list
        }
        return dummyHead.next; // Return the next node of dummy head, which is the actual head of the result list
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        System.out.print("Linked list: ");
        ll.display();
        System.out.println();
        System.out.println("Reversed linked list: ");
        ll.reverse();
        ll.display();
        System.out.println();
        System.out.println("Deleting node having value 3");
        ll.delete(3);
        System.out.print("Linked list after deletion: ");
        ll.display();
        ll.head.next.next.next.next = ll.head.next; // 1->2->4->5->2
        System.out.println();
        System.out.print("Does the linked list contains cycle? "+ll.isCyclic());
        System.out.println();
        System.out.println(
                "Starting point of the loop is: "+ll.cycleStartPoint().value
        );

    }
}