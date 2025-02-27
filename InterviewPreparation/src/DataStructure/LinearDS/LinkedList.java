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
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void delete(int value){
        if(head==null) return;
        if(head.value==value){
            head= head.next;
            return;
        }
        Node current = head;
        while(current.next!=null){
            if(current.next.value==value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
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
            if(slow==fast){
                return true;
            }
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
