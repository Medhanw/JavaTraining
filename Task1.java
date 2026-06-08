import java.util.*;

public class Task1 {
    static class Node{
        int taskId;
        Node next;
        Node(int taskId){
            this.taskId = taskId;
            this.next = null;
        }
    }

    static class TaskQueue{
        Node front, rear;
        int size = 0;

        void enqueue(int taskId){
            Node newNode = new Node(taskId);
            if(rear == null){
                front = rear = newNode;
            }else{
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }
        boolean isEmpty(){
            return front == null;
        }

    }

    public static void main(String[] args){
        int totalTasks = 3;

        TaskQueue teamA = new TaskQueue();
        TaskQueue teamB = new TaskQueue();
        TaskQueue teamC = new TaskQueue();

        for(int i = 1; i <= totalTasks; i++){
            teamA.enqueue(i);
            teamB.enqueue(i);
            teamC.enqueue(i);

        }

        int peopleA = 2;
        int peopleB = 5;
        int peopleC = 1;

        double timeA = (double) teamA.size / peopleA;
        double timeB = (double) teamB.size / peopleB;

        if(peopleB > teamB.size){
            timeB = 1.0;
        }

        double timeC = (double) teamC.size / peopleC;

        System.out.println("Team A (2 people) takes: " + timeA + "Unit of Time!");
        System.out.println("Team B (5 people) takes: " + timeB + "Unit of Time!");
        System.out.println("Team C (1 person) takes: " + timeC + "Unit of Time!");

        double totalProjectTime = Math.max(timeA, Math.max(timeB, timeC));

        System.out.println("Total time required to complete all given task: " + totalProjectTime + "Units of Time!!");
    }
}
    

