package src;

public class VideoNode {
    String title;
    String director;
    String type;
    int releaseYear;
    int durationMinutes;
    int durationSeconds;
    VideoNode next;

    public VideoNode(String title, String director, String type, int releaseYear, int durationMinutes, int durationSeconds) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.durationMinutes = durationMinutes;
        this.durationSeconds = durationSeconds;
        this.type = type;
        this.next = null;
    }

}
