package src;

class VideoNode {
    String title;
    String director;
    String type;
    int releaseYear;
    int durationMinutes;
    int durationSeconds;
    VideoNode left; 
    VideoNode right; 

    public VideoNode(String title, String director, String type, int releaseYear, int durationMinutes, int durationSeconds) {
        this.title = title;
        this.director = director;
        this.type = type;
        this.releaseYear = releaseYear;
        this.durationMinutes = durationMinutes;
        this.durationSeconds = durationSeconds;
        this.left = null;
        this.right = null;
    }

}
