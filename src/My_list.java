package src;
import java.util.Scanner;

public class My_list {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SongLinkedList songList = new SongLinkedList();
    private static final FavoriteTree favoriteTree = new FavoriteTree();
    private static final SongHistory songHistory = new SongHistory();
    private static final PlaySongQueue playSongQueue = new PlaySongQueue();

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
            System.out.println("7. Sort Songs");
            System.out.println("8. View Play History");
            System.out.println("9. Search Song");
            System.out.println("10. Add Song to Queue");
            System.out.println("11. Play Next Song in Queue");
            System.out.print("Choose an option from the above: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addSong(); break;
                case 2: removeSong(); break;
                case 3: playSong(); break;
                case 4: addFavorite(); break;
                case 5: viewFavorites(); break;
                case 6: System.exit(0); break;
                case 7: sortSongs(); break;
                case 8: viewHistory(); break;
                case 9: searchSong(); break;
                case 10: addSongToQueue(); break;
                case 11: playNextSongInQueue(); break;
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
            songHistory.addToHistory(song);
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

    private static void sortSongs() {
        songList.sortSongs();
        System.out.println("Songs have been sorted alphabetically by title.");
    }

    private static void viewHistory() {
        songHistory.viewHistory();
    }

    private static void searchSong() {
        System.out.print("Enter the title of the song to search: ");
        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        if (song != null) {
            System.out.println("Song found: " + song);
        } else {
            System.out.println("Song not found.");
        }
    }

    private static void addSongToQueue() {
        System.out.print("Enter the title of the song to add to queue: ");
        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        if (song != null) {
            playSongQueue.enqueue(song);
            System.out.println("Song added to queue.");
        } else {
            System.out.println("Song not found.");
        }
    }

    private static void playNextSongInQueue() {
        SongNode nextSong = playSongQueue.dequeue();
        if (nextSong != null) {
            System.out.println("Playing next song in queue: " + nextSong);
            songHistory.addToHistory(nextSong);
        } else {
            System.out.println("No songs in the queue.");
        }
    }
}
