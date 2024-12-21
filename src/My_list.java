package src;

import java.util.Scanner;

public class My_list {
    private static final Scanner scanner = new Scanner(System.in);

    private static final SongLinkedList songList = new SongLinkedList();
    private static final PlayList Playlist = new PlayList();

    public static VideoTree Tree = new VideoTree();

    // static boolean Add_Awal = true; // bisa di hapus cuma penambahan simpel

    private static void Add_Awal() {
        songList.addSong("Song A", "Author A", 2020, 3, 45);
        songList.addSong("Song B", "Author B", 2019, 4, 20);
        songList.addSong("Song C", "Author C", 2021, 2, 58);

        Tree.addVideo("Inception", "Christopher Nolan", "Sci-Fi", 2010, 14, 20);
        Tree.addVideo("The Matrix", "Wachowski Sisters", "Sci-Fi", 1999, 13, 0);
        Tree.addVideo("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 16, 0);
        Tree.addVideo("The Godfather", "Francis Ford Coppola", "Crime", 1972, 17, 0);
        Tree.addVideo("Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 15, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0; 
        Add_Awal();

        do {
            LoadingAnimation();
            clearScreen();
            System.out.println("====================================");
            System.out.println("                My-List           ");
            System.out.println("====================================");
            
            System.out.println("   1. List Lagu");
            System.out.println("   2. List Video");
            System.out.println("   3. Keluar");
            
            System.out.print("\nPilih menu >> ");
            
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    menu_musik();
                    break;
                case 2:
                    menu_video();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default :
                    System.out.println("Invalid choice. Try again");
            }

        } while (pilihan != 3);

        scanner.close();
    }

    public static void menu_musik(){

        int choice;
        do {
            LoadingAnimation();
            clearScreen();
            System.out.println("====================================");
            System.out.println("                 My-List           ");
            System.out.println("              Menu List Lagu       ");
            System.out.println("====================================");

            Playlist.Musikplay();

            System.out.println("    1. Play Song");
            System.out.println("    2. Skip Song");
            System.out.println("    3. Add to Favorites");
            System.out.println("    4. View Favorite Songs");
            System.out.println("    5. View List");
            System.out.println("    6. Lihat History");
            System.out.println("    7. Exit");

            System.out.print("\nPilih menu >> ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: playSong(); break;
                case 2:Playlist.popTop(); break;
                case 3: addFavorite(); break;
                case 4: 
                    clearScreen();
                    System.out.println("kosong");
                    pause();
                    break;
                case 5: menu_list(); break;
                case 6: 
                    clearScreen();
                    Playlist.viewHistory();
                    pause();
                    break;
                case 7: break;

                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    };

    private static void menu_list (){
        int choice;

        do {
            clearScreen();

            songList.displaySongs();

            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Sort Songs by Alphabet");
            System.out.println("4. Sort Songs by Time");
            System.out.println("5. Add To PlayList");
            System.out.println("6. kembali");

            System.out.print("\nPilih menu >> ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addSong(); break;
                case 2: removeSong(); break;
                case 3: songList.sortByAlphabet(); break;
                case 4: songList.sortByTime(); break;
                case 5: Add_To_PlayList();;

                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void Add_To_PlayList (){
        System.out.print("Enter the title of the song to Add: ");

        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        
        if (song != null) {
            System.out.println("Add : " + song.title);
            Playlist.enqueue(song);
        } else {
            System.out.println("Song not found.");
        }
        pause();
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
        pause();
    }

    private static void removeSong() {
        System.out.println();
        System.out.print("Enter the title of the song to remove: ");
        String title = scanner.nextLine();
        songList.removeSong(title);
        pause();
    }

    private static void addFavorite() {
        System.out.println("kosong");
        pause();
    }

    private static void playSong() {
        clearScreen();
        System.out.print("Enter the title of the song to play: ");

        String title = scanner.nextLine();
        SongNode song = songList.findSong(title);
        
        if (song != null) {
            System.out.println("Playing: " + song.title);
            Playlist.addTop(song);
        } else {
            System.out.println("Song not found.");
        }
        pause();
    }

    // Menu utama
    public static void menu_video() {

        while (true) {
            clearScreen();
            System.out.println("================================");
            System.out.println("              My-List           ");
            System.out.println("          Menu List Filem       ");
            System.out.println("================================");

            System.out.println("\n1. Nonton Film");
            System.out.println("2. Lihat Daftar Film");
            System.out.println("3. Tambah Film");
            System.out.println("4. Tambah Film sequel");
            System.out.println("5. Hapus Film");
            System.out.println("6. Keluar");

            System.out.print("\nPilih menu >> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            String title;
            switch (choice) {
                case 1 :
                    System.out.print("Masukkan judul film: ");
                    title = scanner.nextLine();
                    Tree.watchVideo(title);
                    pause();
                    LoadingAnimation();
                    break;
                case 2 : 
                    Tree.displayAllVideos(); 
                    pause();
                    break;
                case 3 : 
                    tambah_film(); 
                    break;
                case 4 : 
                    hapus_Sequel(); 
                    break;
                case 5 : 
                    System.out.print("Masukkan judul film yang ingin dihapus: ");
                    title = scanner.nextLine();
                    Tree.deleteVideo(title);
                    LoadingAnimation();
                    break;
                case 6 : 
                    return;
            }
        }
    }

    public static void tambah_film() {
        System.out.print("Masukkan judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan sutradara: ");
        String director = scanner.nextLine();
        System.out.print("Masukkan tipe: ");
        String type = scanner.nextLine();
        System.out.print("Masukkan tahun rilis: ");
        int year = scanner.nextInt();
        System.out.print("Masukkan durasi menit: ");
        int minutes = scanner.nextInt();
        System.out.print("Masukkan durasi detik: ");
        int seconds = scanner.nextInt();
        scanner.nextLine();
        Tree.addVideo(title, director, type, year, minutes, seconds);
        LoadingAnimation();
    }

    public static void hapus_Sequel() {
        System.out.print("Masukkan judul sebelum : ");
        String titleafter = scanner.nextLine();
        System.out.print("Masukkan judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan sutradara: ");
        String director = scanner.nextLine();
        System.out.print("Masukkan tipe: ");
        String type = scanner.nextLine();
        System.out.print("Masukkan tahun rilis: ");
        int year = scanner.nextInt();
        System.out.print("Masukkan durasi menit: ");
        int minutes = scanner.nextInt();
        System.out.print("Masukkan durasi detik: ");
        int seconds = scanner.nextInt();
        scanner.nextLine();
        Tree.addVideoAfter(titleafter, title, director, type, year, minutes, seconds);
        LoadingAnimation();
    }

    public static void LoadingAnimation() {
        String[] loadingSymbols = {"|", "/", "-", "\\"};
        int loadingTime = 1;
        
        clearScreen();
        System.out.println("Dalam proses loading...");

        int putaran = 0;
        while ( putaran < loadingTime) {
            for (int i = 0; i < loadingSymbols.length; i++) {
                System.out.print("\rLoading " + loadingSymbols[i]); 
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("\nProses loading terganggu!");
                    return;
                } 
            }
            putaran++;
        }
        System.out.println("\rLoading selesai!              ");
    
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Escape sequence untuk membersihkan layar
        System.out.flush();
    }

    private static void pause() {
        scanner.nextLine();
    }
}