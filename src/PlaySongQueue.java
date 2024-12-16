package src;

public class PlaySongQueue {
    private Node front, rear;

    private static class Node {
        SongNode song;
        Node next;

        Node(SongNode song) {
            this.song = song;
        }
    }

    public void enqueue(SongNode song) {
        Node newNode = new Node(song);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public SongNode dequeue() {
        if (front == null) return null;
        SongNode song = front.song;
        front = front.next;
        if (front == null) rear = null;
        return song;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("--- Songs in Queue ---");
        Node current = front;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }
}
