package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0; 
        My_list list = new My_list();

        do {
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
                    list.menu_musik();
                    break;
                case 2:
                    list.menu_video();
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


    public static void LoadingAnimation() throws InterruptedException {
            String[] loadingSymbols = {"|", "/", "-", "\\"};
            int loadingTime = 5;
            
            System.out.println("Dalam proses loading...");

            int putaran = 0;
            while ( putaran < loadingTime) {
                for (int i = 0; i < loadingSymbols.length; i++) {
                    System.out.print("\rLoading " + loadingSymbols[i]); 
                    Thread.sleep(200); 
                }
                putaran++;
            }
            System.out.println("\rLoading selesai!              ");
        
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Escape sequence untuk membersihkan layar
        System.out.flush();
    }
}
