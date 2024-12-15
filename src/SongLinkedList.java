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

    public void sortSongs() {
        if (head == null || head.next == null) return;
    
        boolean swapped;
        do {
            swapped = false;
            SongNode current = head;
            while (current.next != null) {
                if (current.title.compareToIgnoreCase(current.next.title) > 0) {
                    // Swap the data
                    String tempTitle = current.title;
                    String tempAuthor = current.author;
                    int tempYear = current.releaseYear;
                    int tempMinutes = current.minutes;
                    int tempSeconds = current.seconds;
    
                    current.title = current.next.title;
                    current.author = current.next.author;
                    current.releaseYear = current.next.releaseYear;
                    current.minutes = current.next.minutes;
                    current.seconds = current.next.seconds;
    
                    current.next.title = tempTitle;
                    current.next.author = tempAuthor;
                    current.next.releaseYear = tempYear;
                    current.next.minutes = tempMinutes;
                    current.next.seconds = tempSeconds;
    
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
