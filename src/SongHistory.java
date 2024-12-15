package src;

public class SongHistory {
    private Node top;

    private static class Node {
        SongNode song;
        Node next;

        Node(SongNode song) {
            this.song = song;
            this.next = null;
        }
    }

    public void addToHistory(SongNode song) {
        Node newNode = new Node(song);
        newNode.next = top;
        top = newNode;
    }

    public void viewHistory() {
        System.out.println("--- Recently Played Songs ---");
        if (top == null) {
            System.out.println("No songs played yet.");
            return;
        }

        Node current = top;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }
}
