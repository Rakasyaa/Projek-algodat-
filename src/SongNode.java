package src;
public class SongNode {
    String title;
    String author;
    int releaseYear;
    int minutes;
    int seconds;
    SongNode next;

    public SongNode(String title, String author, int releaseYear, int minutes, int seconds) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.minutes = minutes;
        this.seconds = seconds;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d) [%02d:%02d]", title, author, releaseYear, minutes, seconds);
    }
}
