package com.swabhav.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // add elements to the queue
        queue.add("lion");
        queue.add("tiger");
        queue.add("cat");

        // print the queue
        System.out.println("Queue: " + queue);

        // remove the element at the front of the queue
        String front = queue.remove();
        System.out.println("Removed element: " + front);

        // print the updated queue
        System.out.println("Queue after removal: " + queue);

        // add another element to the queue
        queue.add("goat");

        // peek at the element at the front of the queue
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);
        System.out.println("Queue after peek: " + queue);
        
        // queue after poll
        String polled = queue.poll();
        System.out.println("Polled element: " + polled);
        System.out.println("Queue after poll: " + queue);
    }

}
