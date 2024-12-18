package src;

public class PlayList {
    private static final FavoriteTree favoriteTree = new FavoriteTree();

    private Node top;

    private static class Node {
        SongNode song;
        Node next;
        

        Node(SongNode song) {
            this.song = song;
            this.next = null;
        }
    }

    public void addTop(SongNode song) {
        Node newNode = new Node(song);
        newNode.next = top;
        top = newNode;
    }

    public void popTop(){
        if (top != null)
        top = top.next;
    }

    public void enqueue(SongNode song) {
        Node newNode = new Node(song);
        if (top == null) {
            top = newNode;
        } else {
            Node current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;        
        }
    }
    public void Musikplay() {
        if (top != null) {
            System.out.println();
            System.out.println("             Now Playing         ");
            System.out.println(" |> " + top.song.title + " - " + top.song.author);
            System.out.println("====================================");
            
            // Simulasi waktu berjalan
            int totalSeconds = top.song.minutes * 60 + top.song.seconds; // Menghitung total durasi dalam detik
            int progressBarLength = 30; // Panjang progress bar
            int currentSeconds = 0; // Waktu saat ini
            
            while (currentSeconds <= totalSeconds) {
                // Menghitung berapa banyak progress bar yang sudah terisi
                int filledLength = (int) ((double) currentSeconds / totalSeconds * progressBarLength);
                
                // Progress bar bergerak
                String progressBar = "0:00 ";
                progressBar += "|"; 
                
                for (int i = 0; i < filledLength; i++) {
                    progressBar += "="; // Bagian progress yang terisi
                }
                
                progressBar += ">";
                
                for (int i = filledLength; i < progressBarLength; i++) {
                    progressBar += "-"; // Bagian progress yang belum terisi
                }
                
                progressBar += "| ";
                
                // Menghitung menit dan detik saat ini
                int currentMinutes = currentSeconds / 60;
                int currentRemainingSeconds = currentSeconds % 60;
                String timeNow = String.format("%02d:%02d", currentMinutes, currentRemainingSeconds);
                
                // Menampilkan waktu saat ini dan total durasi
                progressBar += timeNow + " / " + String.format("%02d:%02d", top.song.minutes, top.song.seconds);
                
                // Menampilkan progress bar
                System.out.print("\r" + progressBar); // \r untuk menimpa baris sebelumnya
                try {
                    Thread.sleep(10); // Delay 1 detik
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                currentSeconds++;
            }
        }
    }
    

    public void viewHistory() {
        System.out.println("================================");
        System.out.println("      Recently Played Songs     ");
        System.out.println("================================");
        System.out.println();
        if (top == null) {
            System.out.println("No songs played yet.");
            return;
        }

        Node current = top;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }

    public void displayFavorites(){
        favoriteTree.displayFavorites();
    }

    public void addFavorite(SongNode song) {
        favoriteTree.addFavorite(song);
    }
}
