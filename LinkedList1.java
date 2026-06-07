public class LinkedList1 {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node addAtHead(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        return newNode;
    }

    static Node addAtTail(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    static Node addAtPos(Node head, int val, int pos) {
        Node newNode = new Node(val);

        if (pos == 1) {
            return addAtHead(head, val);
        }

        Node temp = head;

        for (int i = 1; i <= pos - 2; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // Delete Head Method
    static Node deleteHead(Node head) {
        if (head == null) {
            return null;
        }

        return head.next;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    static Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node turtle = head;
        Node rabbit = head;
        // FIX: Swapped order to avoid checking .next on a null reference
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }
        return turtle;
    }

    static boolean detectCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node turtle = head;
        Node rabbit = head;

        // FIX: Simplified safety check loop condition
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;

            if (turtle == rabbit) {
                return true;
            }
        }
        return false; // FIX: Positioned cleanly outside the loop execution
    }

    static Node startofCycle(Node head) {
        if (head == null) {
            return null;
        }
        Node turtle = head;
        Node rabbit = head;
        while (rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                turtle = head;
                while (turtle != rabbit) {
                    turtle = turtle.next;
                    rabbit = rabbit.next;
                }
                return turtle;
            }
        }
        return null;
    }

    static Node Reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Creating a cyclic linked list: 10 -> 20 -> 30 -> 40 -> (loops back to 30)
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = head1.next.next;

        // Testing Cycle Detection
        System.out.println("Is cycle detected? " + detectCycle(head1));

        // Testing Start of Cycle Location
        Node cycleStart = startofCycle(head1);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node value: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected.");
        }

    }
}