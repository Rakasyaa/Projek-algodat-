package src;
public class SongLinkedList {
    private SongNode head;

    public void addSong(String title, String author, int releaseYear, int minutes, int seconds) {
        SongNode newSong = new SongNode(title, author, releaseYear, minutes, seconds);
        if (head == null) {
            head = newSong;
        } else {
            SongNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
    }

    public void removeSong(String title) {
        if (head == null) return;
        
        if (head.title.equalsIgnoreCase(title)) {
            head = head.next;
            return;
        }

        SongNode current = head;
        while (current.next != null) {
            if (current.next.title.equalsIgnoreCase(title)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void displaySongs() {
        if (head == null) {
            System.out.println("No songs in the list.");
            return;
        }
        
        SongNode current = head;
        System.out.println("--- Song List ---");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public SongNode findSong(String title) {
        SongNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) return current;
            current = current.next;
        }
        return null;
    }
}
