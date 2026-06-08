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
                System.out.println("Queue is empty");
                return;
            }
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }


        static int peek() {
            if (front == null) {
                System.out.println("Queue is empty");
                return -1; // Return -1 to indicate the queue is empty
            }
            return front.data;
        }


        static void display() {
           if (front == null && rear == null) {
                System.out.println("Queue is empty");
                return;
            } 
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
      

    }
public class Queue {





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

        void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        void dequeue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }

        void display() {
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue after enqueuing 10, 20, 30:");
        queue.display();

        queue.dequeue();
        System.out.println("Queue after dequeuing one element:");
        queue.display();

        queue.dequeue();
        queue.dequeue();
        System.out.println("Queue after dequeuing all elements:");
        queue.display();    

    }

    
}