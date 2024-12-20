package src;

public class VideoLinkedList {
    private VideoNode head;

    public void addVideo(String title, String director,String type, int releaseYear, int durationMinutes, int durationSeconds) {
        VideoNode newVideo = new VideoNode(title, director,type, releaseYear, durationMinutes, durationSeconds);
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
        if (head == null) {
            System.out.println("The video list is empty. No video to remove.");
            return;
        }
    
        if (head.title.equalsIgnoreCase(title)) {
            head = head.next; 
            System.out.println("Video \"" + title + "\" removed successfully.");
            return;
        }
        
        VideoNode current = head;
        while (current.next != null) {
            if (current.next.title.equalsIgnoreCase(title)) {
                System.out.println("Video \"" + title + "\" removed successfully.");
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void displayAllVideos() {
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

    public void displayVideosByType(String type) {
        if (head == null) {
            System.out.println("No videos in the list.");
            return;
        }

        VideoNode current = head;
        System.out.println("--- " + type + " List ---");
        while (current != null) {
            if (current.type.equalsIgnoreCase(type)) {
                System.out.println(current);
            }
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
