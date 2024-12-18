package src;
import java.util.Scanner;

public class My_list {
    private static final Scanner scanner = new Scanner(System.in);

    private static final SongLinkedList songList = new SongLinkedList();
    private static final PlayList Playlist = new PlayList();

    private static final VideoLinkedList videoList = new VideoLinkedList();

    boolean Add_Awal = true;

    private static void Add_Awal() {
        songList.addSong("Song A", "Author A", 2020, 3, 45);
        songList.addSong("Song B", "Author B", 2019, 4, 20);
        songList.addSong("Song C", "Author C", 2021, 2, 58);


    }

    public void menu_musik(){
        if (Add_Awal){
            Add_Awal();
            Add_Awal = false;
        }

        int choice;
        do {
            System.out.println("====================================");
            System.out.println("                 My-List           ");
            System.out.println("              Menu List Lagu       ");
            System.out.println("====================================");
            
            Playlist.Musikplay();

            System.out.println("1. Play Song");
            System.out.println("2. Skip Song");
            System.out.println("3. Add to Favorites");
            System.out.println("4. View Favorite Songs");
            System.out.println("5. View List");
            System.out.println("6. Lihat PlayList");
            System.out.println("7. Exit");

            System.out.print("\nPilih menu >> ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: playSong(); break;
                case 2: Playlist.popTop(); break;
                case 3: addFavorite(); break;
                case 4: Playlist.displayFavorites(); break;
                case 5: menu_list(); break;
                case 6: Playlist.viewHistory();
                case 7: break;

                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    };

    private void menu_list (){
    
        int choice;

        do {
            songList.displaySongs();

            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Sort Songs");
            System.out.println("4. Add To PlayList");
            System.out.println("5. kembali");

            System.out.print("\nPilih menu >> ");

            choice = scanner.nextInt();
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
                case 12: addVideo(); break;
                case 13: removeVideo(); break;
                case 14: displayVideosByType(); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private void Add_To_PlayList (){
        System.out.print("Enter the title of the song to Add: ");

        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        
        if (song != null) {
            System.out.println("Add : " + song.title);
            Playlist.enqueue(song);
        } else {
            System.out.println("Song not found.");
        }
    }

    private static void addSong() {
        System.out.println();
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
        System.out.println();
        System.out.print("Enter the title of the song to remove: ");
        String title = scanner.nextLine();
        songList.removeSong(title);
    }

    private static void addFavorite() {
        System.out.print("Enter the title of the song to add to favorites: ");
        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        if (song != null) {
            Playlist.addFavorite(song);
            System.out.println("Added to favorites.");
        } else {
            System.out.println("Song not found.");
        }
    }

    private static void playSong() {
        System.out.print("Enter the title of the song to play: ");

        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        
        if (song != null) {
            System.out.println("Playing: " + song.title);
            Playlist.addTop(song);
        } else {
            System.out.println("Song not found.");
        }
    }

    public void menu_video(){

        System.out.println("================================");
        System.out.println("              My-List           ");
        System.out.println("          Menu List Filem       ");
        System.out.println("================================");

        System.out.println("1. Add Video");
        System.out.println("2. Remove Video");
        System.out.println("3. View Video List");

        System.out.print("\nPilih menu >> ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: addVideo(); break;
            case 2: removeVideo(); break;
            case 3: viewVideos(); break;
            default: System.out.println("Invalid choice. Try again.");
        }
    };

    private static void addVideo() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter release year: ");
        int releaseYear = scanner.nextInt();
        System.out.print("Enter duration (minutes): ");
        int durationMinutes = scanner.nextInt();
        System.out.print("Enter duration (seconds): ");
        int durationSeconds = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter type (Film/Podcast): ");
        String type = scanner.nextLine();

        if (!type.equalsIgnoreCase("Film") && !type.equalsIgnoreCase("Podcast")) {
            System.out.println("Invalid type entered. Defaulting to 'Film'.");
            type = "Film";
        }

        videoList.addVideo(title, director, releaseYear, durationMinutes, durationSeconds, type);
        System.out.println("Video added successfully.");
    }

    private static void displayVideosByType() {
        System.out.print("Enter type to display (Film/Podcast): ");
        String type = scanner.nextLine();
        videoList.displayVideosByType(type);
    }

    private static void removeVideo() {
        System.out.print("Enter the title of the video to remove: ");
        String title = scanner.nextLine();
        videoList.removeVideo(title);
    }

}
