import java.util.*;

// Class representing a song node in the linked list
class SongNode {
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

    public String toString() {
        return String.format("%s by %s (%d) [%02d:%02d]", title, author, releaseYear, minutes, seconds);
    }
}

// Linked List class for the songs
class SongLinkedList {
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

// Class representing a node in the binary tree for favorite songs
class TreeNode {
    SongNode song;
    TreeNode left, right;

    public TreeNode(SongNode song) {
        this.song = song;
    }
}

// Binary Tree for favorite songs
class FavoriteTree {
    private TreeNode root;

    public void addFavorite(SongNode song) {
        root = addRecursive(root, song);
    }

    private TreeNode addRecursive(TreeNode current, SongNode song) {
        if (current == null) return new TreeNode(song);

        if (song.title.compareToIgnoreCase(current.song.title) < 0) {
            current.left = addRecursive(current.left, song);
        } else {
            current.right = addRecursive(current.right, song);
        }
        return current;
    }

    public void displayFavorites() {
        System.out.println("--- Favorite Songs ---");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.song);
            inOrderTraversal(node.right);
        }
    }
}

public class My_list {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SongLinkedList songList = new SongLinkedList();
    private static final FavoriteTree favoriteTree = new FavoriteTree();

    public static void main(String[] args) {
        initializeStaticSongs();
        
        while (true) {
            songList.displaySongs();
            System.out.println("\nMenu:");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Song");
            System.out.println("4. Add to Favorites");
            System.out.println("5. View Favorite Songs");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addSong(); break;
                case 2: removeSong(); break;
                case 3: playSong(); break;
                case 4: addFavorite(); break;
                case 5: viewFavorites(); break;
                case 6: System.exit(0); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeStaticSongs() {
        songList.addSong("Song A", "Author A", 2020, 3, 45);
        songList.addSong("Song B", "Author B", 2019, 4, 20);
        songList.addSong("Song C", "Author C", 2021, 2, 58);
    }

    private static void addSong() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter release year: ");
        int year = scanner.nextInt();
        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();
        scanner.nextLine();
        songList.addSong(title, author, year, minutes, seconds);
    }

    private static void removeSong() {
        System.out.print("Enter the title of the song to remove: ");
        String title = scanner.nextLine();
        songList.removeSong(title);
    }

    private static void playSong() {
        System.out.print("Enter the title of the song to play: ");
        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        if (song != null) {
            System.out.println("Playing: " + song);
        } else {
            System.out.println("Song not found.");
        }
    }

    private static void addFavorite() {
        System.out.print("Enter the title of the song to add to favorites: ");
        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        if (song != null) {
            favoriteTree.addFavorite(song);
            System.out.println("Added to favorites.");
        } else {
            System.out.println("Song not found.");
        }
    }

    private static void viewFavorites() {
        favoriteTree.displayFavorites();
    }
}
