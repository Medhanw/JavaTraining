class QueueOps {
    static Node front = null;
    static Node rear = null;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        } 
        rear.next = newNode;
        rear = newNode;
    }

    static void dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty: ");
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    static int peek() {
        if (front == null) {
            System.out.println("Queue is empty: ");
            return -1;
        }
        return front.data;
    }

    static void display() {
        if (front == null && rear == null) {
            System.out.println("Queue is Empty: ");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Renamed to match the file name "Mergequeue.java" and un-nested from QueueOps
public class Mergequeue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLinkedList {
        Node front;
        Node rear;

        QueueLinkedList() {
            this.front = null;
            this.rear = null;
        }

        boolean isEmpty() {
            return front == null;
        }

        int peek() {
            if (isEmpty()) return -1;
            return front.data;
        }

        void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        int dequeue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }

        void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static QueueLinkedList mergeSortedQueues(QueueLinkedList q1, QueueLinkedList q2) {
        QueueLinkedList mergedResult = new QueueLinkedList();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                mergedResult.enqueue(q1.dequeue());
            } else {
                mergedResult.enqueue(q2.dequeue());
            }
        }

        while (!q1.isEmpty()) {
            mergedResult.enqueue(q1.dequeue());
        }

        while (!q2.isEmpty()) {
            mergedResult.enqueue(q2.dequeue());
        }

        return mergedResult;
    }

    public static void main(String[] args) {
        QueueLinkedList queue1 = new QueueLinkedList();
        QueueLinkedList queue2 = new QueueLinkedList();

        queue1.enqueue(1);
        queue1.enqueue(4);
        queue1.enqueue(5);
        queue1.enqueue(8);

        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(6);
        queue2.enqueue(7);
        queue2.enqueue(9);

        System.out.print("Queue 1: ");
        queue1.display();

        System.out.print("Queue 2: ");
        queue2.display();

        QueueLinkedList sortedResult = mergeSortedQueues(queue1, queue2);

        System.out.print("Merged Sorted Queue: ");
        sortedResult.display();    
    }
}