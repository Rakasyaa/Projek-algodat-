package src;

import java.util.Scanner;

public class Mai {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0; // Indeks menu saat ini


        LoadingAnimation();

        while (true) {
            clearScreen();
            System.out.println("================================");
            System.out.println("        MENU INTERAKTIF         ");
            System.out.println("================================");

            if (pilihan == 0) System.out.println(">> 1. List Lagu");
            else System.out.println("   1. List Lagu");
            
            if (pilihan == 1) System.out.println(">> 2. List Video");
            else System.out.println("   2. List Video");
            
            if (pilihan == 2) System.out.println(">> 3. Lihat Biasa");
            else System.out.println("   3. Lihat Biasa");
            
            if (pilihan == 3) System.out.println(">> 4. Keluar");
            else System.out.println("   4. Keluar");

            System.out.println("\nGunakan W/S untuk navigasi, Enter untuk pilih");

            System.out.print("Pilih aksi (W/S/Enter): ");
            char input = scanner.nextLine().charAt(0); // Membaca karakter pertama dari input

            if (input == 'w' || input == 'W') {
                pilihan--;
                if (pilihan < 0) pilihan = 3; // Loop ke bawah ke opsi terakhir
            } else if (input == 's' || input == 'S') {
                pilihan++;
                if (pilihan > 3) pilihan = 0; // Loop ke atas ke opsi pertama
            } else if (input == '\n') { // Jika enter ditekan
                switch (pilihan) {
                    case 0:
                        tampilkanListLagu();
                        break;
                    case 1:
                        tampilkanListVideo();
                        break;
                    case 2:
                        tampilkanLihatBiasa();
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan program ini!");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public static void LoadingAnimation() throws InterruptedException {

            String[] loadingSymbols = {"|", "/", "-", "\\"}; // Simbol rotasi loading
            int loadingTime = 5; // Waktu loading dalam detik
            
            System.out.println("Memulai proses loading...");
            
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) / 1000 < loadingTime) {
                for (int i = 0; i < loadingSymbols.length; i++) {
                    System.out.print("\rLoading " + loadingSymbols[i]); // \r mengembalikan kursor ke awal baris
                    Thread.sleep(200); // Jeda waktu sebelum simbol berikutnya ditampilkan
                }
            }
    
            System.out.println("\rLoading selesai!              "); // Hapus simbol loading saat selesai
        
    }
    

    private static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Escape sequence untuk membersihkan layar
        System.out.flush();
    }

    private static void tampilkanListLagu() {
        clearScreen();
        System.out.println("================================");
        System.out.println("         DAFTAR LAGU            ");
        System.out.println("================================");
        System.out.println("1. Lagu 1 - Artis 1");
        System.out.println("2. Lagu 2 - Artis 2");
        System.out.println("3. Lagu 3 - Artis 3");
        System.out.println("\nTekan Enter untuk kembali ke menu...");
        new Scanner(System.in).nextLine();
    }

    private static void tampilkanListVideo() {
        clearScreen();
        System.out.println("================================");
        System.out.println("         DAFTAR VIDEO           ");
        System.out.println("================================");
        System.out.println("1. Video 1 - Kategori 1");
        System.out.println("2. Video 2 - Kategori 2");
        System.out.println("3. Video 3 - Kategori 3");
        System.out.println("\nTekan Enter untuk kembali ke menu...");
        new Scanner(System.in).nextLine();
    }

    private static void tampilkanLihatBiasa() {
        clearScreen();
        System.out.println("================================");
        System.out.println("           LIHAT BIASA           ");
        System.out.println("================================");
        System.out.println("Ini adalah tampilan biasa yang sederhana.");
        System.out.println("\nTekan Enter untuk kembali ke menu...");
        new Scanner(System.in).nextLine();
    }
}
