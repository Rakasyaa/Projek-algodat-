package src;

public class VideoLinkedList {
    private VideoNode head;

    public void addVideo(String title, String director, int releaseYear, int durationMinutes, int durationSeconds) {
        VideoNode newVideo = new VideoNode(title, director, releaseYear, durationMinutes, durationSeconds);
        if (head == null) {
            head = newVideo;
        } else {
            VideoNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newVideo;
        }
    }

    public void removeVideo(String title) {
        if (head == null) return;

        if (head.title.equalsIgnoreCase(title)) {
            head = head.next;
            return;
        }

        VideoNode current = head;
        while (current.next != null) {
            if (current.next.title.equalsIgnoreCase(title)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void displayVideos() {
        if (head == null) {
            System.out.println("No videos in the list.");
            return;
        }

        VideoNode current = head;
        System.out.println("--- Video List ---");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public VideoNode findVideo(String title) {
        VideoNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) return current;
            current = current.next;
        }
        return null;
    }
}
