package src;

public class VideoNode {
    String title;
    String director;
    int releaseYear;
    int durationMinutes;
    int durationSeconds;
    String type;
    VideoNode next;

    public VideoNode(String title, String director, int releaseYear, int durationMinutes, int durationSeconds, String type) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.durationMinutes = durationMinutes;
        this.durationSeconds = durationSeconds;
        this.type = type;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s by %s (%d) [%02d:%02d]", type, title, director, releaseYear, durationMinutes, durationSeconds);
    }
}
